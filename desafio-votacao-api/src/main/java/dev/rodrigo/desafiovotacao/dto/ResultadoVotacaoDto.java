package dev.rodrigo.desafiovotacao.dto;

import dev.rodrigo.desafiovotacao.enums.ResultadoVotacao;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoVotacaoDto {
  private Long sessaoId;
  private long votosSim;
  private long votosNao;
  private long total;
  private ResultadoVotacao resultado;
}
