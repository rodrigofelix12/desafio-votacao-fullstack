package dev.rodrigo.desafiovotacao.service;

import dev.rodrigo.desafiovotacao.dto.PautaRequestDto;
import dev.rodrigo.desafiovotacao.entity.Pauta;
import dev.rodrigo.desafiovotacao.repository.PautaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PautaService {

  private final PautaRepository repository;

  public void criarNovaPauta(PautaRequestDto dto) {
    Pauta pauta = new Pauta();
    pauta.setTitulo(dto.getTitulo());
    pauta.setDescricao(dto.getDescricao());
    repository.save(pauta);
  }

  public Pauta buscarPautaPorId(Long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Pauta ID " + id + " não encontrada"));
  }

  public List<Pauta> buscarPautas() {
    return repository.findAll();
  }
}
