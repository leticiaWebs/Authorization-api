package br.com.fiap.hackaton.authorization.mock;

import br.com.fiap.hackaton.authorization.record.CreateCredentialsDto;

public class CreateCredentialsDtoMock {
    public static CreateCredentialsDto mock() {
        return new CreateCredentialsDto(
                "email",
                "fullname",
                "password",
                true);
    }
}
