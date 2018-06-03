package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "suggestion_hour")
@Inheritance(strategy = InheritanceType.JOINED)
public class SuggestionHour extends GenericClass {
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "visit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Visit visitId;
}