package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "configurations")
@Inheritance(strategy = InheritanceType.JOINED)
public class Configurations extends GenericClass {
    private String text;
}