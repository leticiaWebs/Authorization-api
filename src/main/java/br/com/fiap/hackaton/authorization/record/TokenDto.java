package br.com.fiap.hackaton.authorization.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TokenDto(
        @NotNull @NotBlank String userName,
        @NotNull @NotBlank String token) {

}
