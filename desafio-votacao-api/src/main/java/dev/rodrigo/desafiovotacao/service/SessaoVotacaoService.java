package dev.rodrigo.desafiovotacao.service;

import dev.rodrigo.desafiovotacao.dto.SessaoRequestDto;
import dev.rodrigo.desafiovotacao.entity.Pauta;
import dev.rodrigo.desafiovotacao.entity.SessaoVotacao;
import dev.rodrigo.desafiovotacao.enums.StatusSessao;
import dev.rodrigo.desafiovotacao.repository.PautaRepository;
import dev.rodrigo.desafiovotacao.repository.SessaoVotacaoRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessaoVotacaoService {

  private final SessaoVotacaoRepository repository;
  private final PautaRepository pautaRepository;

  public SessaoVotacao abrirSessao(Long pautaId, SessaoRequestDto request) {
    Pauta pauta = validarSePautaExiste(pautaId);

    validarSeExisteSessaoAberta(pautaId);

    LocalDateTime agora = LocalDateTime.now();

    long duracaoMinutos =
        (request.getDuracaoMinutos() == null || request.getDuracaoMinutos() <= 0)
            ? 1
            : request.getDuracaoMinutos();

    SessaoVotacao sessao = new SessaoVotacao();
    sessao.setPauta(pauta);
    sessao.setDataAbertura(agora);
    sessao.setDataFechamento(agora.plusMinutes(duracaoMinutos));
    sessao.setStatus(StatusSessao.ABERTA);

    repository.save(sessao);

    return sessao;
  }

  private void validarSeExisteSessaoAberta(Long pautaId) {
    boolean existeSessaoAberta =
        repository.existsByPautaIdAndDataFechamentoAfter(pautaId, LocalDateTime.now());
    if (existeSessaoAberta) {
      throw new RuntimeException("Já existe uma sessão aberta para essa pauta");
    }
  }

  private Pauta validarSePautaExiste(Long pautaId) {
    return pautaRepository
        .findById(pautaId)
        .orElseThrow(() -> new RuntimeException("Pauta não encontrada"));
  }

  public SessaoVotacao buscarPorId(Long id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
  }
}
