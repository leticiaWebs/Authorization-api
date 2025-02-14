package br.com.fiap.hackaton.authorization.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.hackaton.authorization.configuration.security.TokenService;
import br.com.fiap.hackaton.authorization.mock.AuthenticationMock;
import br.com.fiap.hackaton.authorization.mock.UserMock;
import br.com.fiap.hackaton.authorization.record.AccountCredentialsDto;
import br.com.fiap.hackaton.authorization.record.CreateCredentialsDto;

class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserService userService;

    @Mock
    private TokenService tokenService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.authService = new AuthService(authenticationManager, passwordEncoder, userService, tokenService);
    }

    @Test
    void whenCreateUserReturnUsernameAndRolesByUSer() {
        when(this.passwordEncoder.encode(any())).thenReturn("encoder");
        when(this.userService.create(any())).thenReturn(UserMock.mock());
        final var response = this.authService.create(new CreateCredentialsDto("email", "fullname", "password", true));
        assertNotNull(response);
    }

    @Test
    void whenSuccessSigninReturnUsernameAndToken() {
        
        when(this.userService.loadUserByUsername(anyString())).thenReturn(UserMock.mock());
        when(this.authenticationManager.authenticate((any()))).thenReturn(AuthenticationMock.mock());
        when(this.tokenService.createToken(UserMock.mock())).thenReturn("token");

        final var response = this.authService.signin(new AccountCredentialsDto("email", "password"));
        assertNotNull(response);

    }

}
