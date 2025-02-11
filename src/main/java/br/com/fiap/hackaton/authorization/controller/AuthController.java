package br.com.fiap.hackaton.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.hackaton.authorization.record.AccountCredentialsDto;
import br.com.fiap.hackaton.authorization.record.CreateCredentialsDto;
import br.com.fiap.hackaton.authorization.record.TokenDto;
import br.com.fiap.hackaton.authorization.record.ValidUserCreateDto;
import br.com.fiap.hackaton.authorization.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;

@Tag(name = "Authentication", description = "Endpoints for Managing token")
@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Create a new users", tags = { "Authentication" })
    @PostMapping("/create")
    public ResponseEntity<ValidUserCreateDto> create(@RequestBody @NotNull final CreateCredentialsDto data) {
        final var response = this.authService.create(data);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Authenticates a user and returns a token", tags = { "Authentication" })
    @PostMapping("/signin")
    public ResponseEntity<TokenDto> signin(@RequestBody @NotNull final AccountCredentialsDto data) {
        final var response = this.authService.signin(data);
        return ResponseEntity.ok(response);
    }

}
