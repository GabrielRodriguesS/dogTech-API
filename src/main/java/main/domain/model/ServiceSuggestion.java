package main.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;

@Entity
@Data
@Table(name = "service_suggestion")
@Inheritance(strategy = InheritanceType.JOINED)
public class ServiceSuggestion extends GenericClass {
    @Basic(optional = false)
    private String service;
    private String description;
    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person personId;
}