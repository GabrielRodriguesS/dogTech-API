package main.domain.model;

import lombok.Data;
import main.domain.model.enums.Complement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "address")
public class Address implements Serializable {
    //TODO refatorar para se tornar um Embeddable com person
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String number;
    @Enumerated(EnumType.STRING)
    private Complement complement;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person personId;


}
