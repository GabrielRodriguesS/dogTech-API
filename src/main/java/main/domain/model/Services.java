package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "services")
@Inheritance(strategy = InheritanceType.JOINED)
public class Services extends GenericClass {
    @Basic(optional = false)
    private String name;
    private Integer value;
    private String link;
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Photo photoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicesId1")
    private List<ServicesPerson> servicesPersonList;
}