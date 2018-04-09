package main.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "services_person")
public class ServicesPerson implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServicesPersonPK servicesPersonPK;
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(mappedBy = "servicesPerson")
    private List<Photo> photoList;
    @JoinColumn(name = "person_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person personId1;
    @JoinColumn(name = "services_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Services servicesId1;
}