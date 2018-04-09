package main.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "services")
public class Services implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
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