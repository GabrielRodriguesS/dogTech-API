package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;

@Entity
@Data
@Table(name = "donations_made")
@Inheritance(strategy = InheritanceType.JOINED)
public class DonationsMade extends GenericClass {
    private String origin;
    @JoinColumn(name = "donations_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Donations donationsId;
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Photo photoId;
}