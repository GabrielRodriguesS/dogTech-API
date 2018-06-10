package main.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @JsonBackReference
    @JoinColumn(name = "person_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person personId1;
    @JoinColumn(name = "services_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Services servicesId1;
}