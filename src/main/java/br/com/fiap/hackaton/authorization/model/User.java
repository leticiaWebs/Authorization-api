package br.com.fiap.hackaton.authorization.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users", schema = "hackaton")
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "account_non_expired", nullable = false)
    private Boolean accountNonExpired;

    @Column(name = "account_non_locked", nullable = false)
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired", nullable = false)
    private Boolean credentialsNonExpired;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "hackaton", name = "user_permission", 
        joinColumns = @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "fk_user_user_permission")), 
        inverseJoinColumns = @JoinColumn(name = "id_permission", foreignKey = @ForeignKey(name = "fk_permission_user_permission"))
    )
    private List<Permission> permissions;

    public User() { }

    public User(String username, String fullName, String password, Boolean accountNonExpired, Boolean accountNonLocked,
            Boolean credentialsNonExpired, Boolean enabled) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        for (var permission : permissions) {
            roles.add(permission.getDescription());
        }
        return roles;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissions;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}
