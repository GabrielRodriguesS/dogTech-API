package main.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;

@Data
@Entity
@Table(name = "telephone")
@Inheritance(strategy = InheritanceType.JOINED)
public class Telephone extends GenericClass {
    private String number;
    private boolean whatsapp;
    private String identifier;
    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person personId;
}