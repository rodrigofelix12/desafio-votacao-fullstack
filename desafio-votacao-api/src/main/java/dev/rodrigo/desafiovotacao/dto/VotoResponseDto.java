package dev.rodrigo.desafiovotacao.dto;

import dev.rodrigo.desafiovotacao.enums.TipoVoto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VotoResponseDto {
  private Long id;
  private Long sessaoId;
  private String associadoId;
  private TipoVoto voto;
  private LocalDateTime dataHora;
}
