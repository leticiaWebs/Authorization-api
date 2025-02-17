package br.com.fiap.hackaton.authorization.mock;

import br.com.fiap.hackaton.authorization.record.AccountCredentialsDto;

public class AccountCredentialsDtoMock {

    public static AccountCredentialsDto mock() {
        return new AccountCredentialsDto("email", "password");
    }

}
