package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "visit")
@Inheritance(strategy = InheritanceType.JOINED)
public class Visit extends GenericClass {
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visitId")
    private List<SuggestionHour> suggestionHourList;
    @JoinColumn(name = "adoption_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Adoption adoptionId;
}