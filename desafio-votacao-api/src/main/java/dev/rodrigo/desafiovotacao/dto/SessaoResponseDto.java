package dev.rodrigo.desafiovotacao.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SessaoResponseDto {
  private Long id;
  private Long pautaId;
  private LocalDateTime dataAbertura;
  private LocalDateTime dataFechamento;
  private boolean aberta;
}
