package main.domain.dto;

import lombok.Data;
import main.domain.model.Person;
import main.domain.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class PersonDTO implements UserDetails {
    private String email;
    private String password;
    private boolean defaultPassword;
    private ArrayList<Role> roles;

    public PersonDTO(Person person) {
        this.email = person.getEmail();
        this.password = person.getPassword();
        this.defaultPassword = person.isDefaultPassword();
        this.roles = new ArrayList<>(person.getRoleList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles();
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isDefaultPassword();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
