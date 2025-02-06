package br.com.fiap.hackaton.authorization.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AccountCredentialsDto(
        @NotNull @NotBlank @NotEmpty String email,
        @NotNull @NotBlank @NotEmpty String password) {

}
