package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;
import main.domain.model.enums.Roles;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "role")
@Inheritance(strategy = InheritanceType.JOINED)
public class Role extends GenericClass {
    @Enumerated(EnumType.STRING)
    private Roles name;
    @JoinTable(name = "role_person", joinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "person_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Person> personList;
}