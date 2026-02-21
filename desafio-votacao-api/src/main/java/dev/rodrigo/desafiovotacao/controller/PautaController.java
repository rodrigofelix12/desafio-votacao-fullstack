package dev.rodrigo.desafiovotacao.controller;

import dev.rodrigo.desafiovotacao.dto.PautaRequestDto;
import dev.rodrigo.desafiovotacao.dto.PautaResponseDto;
import dev.rodrigo.desafiovotacao.mappers.PautaMapper;
import dev.rodrigo.desafiovotacao.service.PautaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api")
public class PautaController {

  private final PautaService service;
  private final PautaMapper mapper;

  @GetMapping("/{id}")
  public PautaResponseDto buscarPautaPorId(@PathVariable Long id) {
    return mapper.toPautaResponseDto(service.buscarPautaPorId(id));
  }

  @GetMapping()
  public List<PautaResponseDto> buscarPautas() {
    return mapper.toPautaResponseList(service.buscarPautas());
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public void criarPauta(@RequestBody PautaRequestDto dto) {
    service.criarNovaPauta(dto);
  }
}
