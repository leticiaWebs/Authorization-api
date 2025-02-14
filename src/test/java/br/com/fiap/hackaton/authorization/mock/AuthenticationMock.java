package br.com.fiap.hackaton.authorization.mock;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class AuthenticationMock {
    public static Authentication mock() {
        return new Authentication() {

            @Override
            public String getName() {
                return "";
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
            }

            @Override
            public Object getCredentials() {
                throw new UnsupportedOperationException("Unimplemented method 'getCredentials'");
            }

            @Override
            public Object getDetails() {
                throw new UnsupportedOperationException("Unimplemented method 'getDetails'");
            }

            @Override
            public Object getPrincipal() {
                return UserMock.mock();
            }

            @Override
            public boolean isAuthenticated() {
                return true;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
                throw new UnsupportedOperationException("Unimplemented method 'setAuthenticated'");
            }

        };
    }
}
