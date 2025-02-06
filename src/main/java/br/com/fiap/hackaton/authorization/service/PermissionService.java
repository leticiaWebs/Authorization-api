package br.com.fiap.hackaton.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.hackaton.authorization.model.Permission;
import br.com.fiap.hackaton.authorization.repository.PermissionRepository;


@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionService(final PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public Permission getPermission(final boolean isDoctor) {        
        if (isDoctor) {
            return this.permissionRepository.getPermissionByDescription("DOCTOR");
        }
        return this.permissionRepository.getPermissionByDescription("PATIENT");
    }

}
