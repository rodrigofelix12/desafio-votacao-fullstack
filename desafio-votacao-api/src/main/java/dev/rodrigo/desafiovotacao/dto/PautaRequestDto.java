package dev.rodrigo.desafiovotacao.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PautaRequestDto {
  @NotBlank private String titulo;

  @NotBlank private String descricao;
}
