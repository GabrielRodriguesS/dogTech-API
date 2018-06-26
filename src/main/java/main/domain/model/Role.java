package main.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import main.domain.model.Generic.GenericClass;
import main.domain.model.enums.Roles;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "role")
@Inheritance(strategy = InheritanceType.JOINED)
public class Role extends GenericClass implements GrantedAuthority {
    @Enumerated(EnumType.STRING)
    private Roles name;
    @JsonIgnore
    @JoinTable(name = "role_person", joinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "person_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Person> personList;

    @Override
    public String getAuthority() {
        return this.name.name();
    }
}