package br.com.fiap.hackaton.authorization.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.hackaton.authorization.model.Permission;


@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    
    @Query("SELECT permission FROM Permission permission WHERE permission.description = :description ")
    Permission getPermissionByDescription(@Param("description") String description);
}
