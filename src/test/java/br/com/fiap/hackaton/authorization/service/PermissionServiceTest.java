package br.com.fiap.hackaton.authorization.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.fiap.hackaton.authorization.model.Permission;
import br.com.fiap.hackaton.authorization.repository.PermissionRepository;

class PermissionServiceTest {

    @InjectMocks
    private PermissionService permissionService;

    @Mock
    private PermissionRepository permissionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.permissionService = new PermissionService(permissionRepository);
    }

    @ParameterizedTest
    @CsvSource({ "true, DOCTOR", "false, PATIENT" })
    void shouldPermissionsByDoctorIsTrueOrFalse(boolean input, String expectedPermission) {
        when(this.permissionRepository.getPermissionByDescription(expectedPermission))
                .thenReturn(new Permission(expectedPermission));

        final var response = this.permissionService.getPermission(input);

        assertNotNull(response);
        assertEquals(expectedPermission, response.getDescription());
    }
}
