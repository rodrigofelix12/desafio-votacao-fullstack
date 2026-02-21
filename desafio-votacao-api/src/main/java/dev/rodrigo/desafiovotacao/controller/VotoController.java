package dev.rodrigo.desafiovotacao.controller;

import dev.rodrigo.desafiovotacao.dto.ResultadoVotacaoDto;
import dev.rodrigo.desafiovotacao.dto.VotoRequestDto;
import dev.rodrigo.desafiovotacao.dto.VotoResponseDto;
import dev.rodrigo.desafiovotacao.mappers.VotoMapper;
import dev.rodrigo.desafiovotacao.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votos")
@RequiredArgsConstructor
@Validated
public class VotoController {

  private final VotoService service;
  private final VotoMapper mapper;

  @PostMapping("/sessao/{sessaoId}")
  public ResponseEntity<VotoResponseDto> votar(
      @PathVariable Long sessaoId, @RequestBody VotoRequestDto request) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(mapper.toVotoResponseDto(service.votar(sessaoId, request)));
  }

  @GetMapping("/sessao/{sessaoId}/resultado")
  public ResultadoVotacaoDto resultado(@PathVariable Long sessaoId) {
    return service.contabilizar(sessaoId);
  }
}
