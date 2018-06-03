package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "photographer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Photographer extends GenericClass {
    private String name;
    private String contact;
    @Column(name = "link_portifolio")
    private String linkPortifolio;
    @OneToMany(mappedBy = "photographerId")
    private List<Photo> photoList;
}