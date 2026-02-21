package dev.rodrigo.desafiovotacao.dto;

import dev.rodrigo.desafiovotacao.enums.TipoVoto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

@Data
public class VotoRequestDto {

    @NotBlank
    private String associadoId;

    @NonNull
    private TipoVoto voto;
}
