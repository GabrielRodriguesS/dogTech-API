package main.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "donations_made")
public class DonationsMade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    private String origin;
    @JoinColumn(name = "donations_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Donations donationsId;
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Photo photoId;
}