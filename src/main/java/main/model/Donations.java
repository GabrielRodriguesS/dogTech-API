package main.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "donations")
public class Donations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donationsId")
    private List<DonationsMade> donationsMadeList;
}