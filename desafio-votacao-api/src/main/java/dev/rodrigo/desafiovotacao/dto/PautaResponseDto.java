package dev.rodrigo.desafiovotacao.dto;

import dev.rodrigo.desafiovotacao.entity.SessaoVotacao;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PautaResponseDto {
  private Long id;

  private String titulo;

  private String descricao;

  private List<SessaoVotacao> sessoes;
}
