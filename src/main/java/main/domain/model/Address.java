package main.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import main.domain.model.Generic.GenericClass;
import main.domain.model.enums.Complement;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
@Inheritance(strategy = InheritanceType.JOINED)
public class Address extends GenericClass {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String number;
    @Enumerated(EnumType.STRING)
    private Complement complement;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonBackReference
    @JsonProperty("person")
    private Person personId;


}
