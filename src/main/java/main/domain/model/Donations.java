package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "donations")
@Inheritance(strategy = InheritanceType.JOINED)
public class Donations extends GenericClass {
    private String item;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donationsId")
    private List<DonationsMade> donationsMadeList;
}