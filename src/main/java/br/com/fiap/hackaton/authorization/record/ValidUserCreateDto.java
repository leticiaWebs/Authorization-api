package br.com.fiap.hackaton.authorization.record;

import java.util.List;

import br.com.fiap.hackaton.authorization.model.User;

public record ValidUserCreateDto(
        String username,
        List<String> roles) {

    public static ValidUserCreateDto toRecord(final User entity) {
            return new ValidUserCreateDto(
                entity.getUsername(),
                entity.getRoles());
        }
}
