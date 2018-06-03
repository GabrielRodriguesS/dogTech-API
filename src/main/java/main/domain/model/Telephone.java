package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;

@Entity
@Data
@Table(name = "telephone")
@Inheritance(strategy = InheritanceType.JOINED)
public class Telephone extends GenericClass {
    private String number;
    private boolean whatsapp;
    private String identifier;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person personId;
}