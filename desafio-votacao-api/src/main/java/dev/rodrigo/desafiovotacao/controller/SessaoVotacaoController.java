package dev.rodrigo.desafiovotacao.controller;

import dev.rodrigo.desafiovotacao.dto.SessaoRequestDto;
import dev.rodrigo.desafiovotacao.dto.SessaoResponseDto;
import dev.rodrigo.desafiovotacao.mappers.SessaoVotacaoMapper;
import dev.rodrigo.desafiovotacao.service.SessaoVotacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sessoes")
public class SessaoVotacaoController {

  private final SessaoVotacaoService service;
  private final SessaoVotacaoMapper mapper;

  @PostMapping("/pauta/{pautaId}")
  public ResponseEntity<SessaoResponseDto> abrirSessao(
      @PathVariable Long pautaId, @RequestBody(required = false) SessaoRequestDto request) {

    if (request == null) {
      request = new SessaoRequestDto();
    }

    SessaoResponseDto response = mapper.toSessaoResponseDto(service.abrirSessao(pautaId, request));

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/{id}")
  public SessaoResponseDto buscarSessao(@PathVariable Long id) {
    return mapper.toSessaoResponseDto(service.buscarPorId(id));
  }

  @PostMapping("sessao/encerrar/{sessaoId}")
  public void encerrarSessao(@PathVariable Long sessaoId) {
    service.encerrarSessao(sessaoId);
  }
}
