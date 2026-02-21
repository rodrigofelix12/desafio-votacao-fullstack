package dev.rodrigo.desafiovotacao.dto;

import dev.rodrigo.desafiovotacao.enums.TipoVoto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class VotoResponseDto {
  private Long id;
  private Long sessaoId;
  private String cpf;
  private TipoVoto voto;
  private LocalDateTime dataHora;
}
