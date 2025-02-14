package br.com.fiap.hackaton.authorization.mock;

import java.util.List;

import br.com.fiap.hackaton.authorization.model.Permission;
import br.com.fiap.hackaton.authorization.model.User;

public class UserMock {
    public static User mock() {
        final var user = new User(
                "username",
                "fullName",
                "password",
                false,
                false,
                false,
                false);
        user.setPermissions(List.of(new Permission("DOCTOR"), new Permission("PATIENT")));
        return user;
    }
    
}
