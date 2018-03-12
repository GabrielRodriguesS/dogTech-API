package main.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "photo")
@Data
public class Photo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "real_path")
    private String realPath;
    @Column(name = "path_thumbnail")
    private String pathThumbnail;
    @Column(name = "photo_link")
    private String photoLink;
    @JoinColumn(name = "adoption_id", referencedColumnName = "id")
    @ManyToOne
    private Adoption adoption;
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    @ManyToOne
    private Animal animal;
    @JoinColumn(name = "photographer_id", referencedColumnName = "id")
    @ManyToOne
    private Photographer photographer;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne
    private Person person;
    @JoinColumn(name = "post_adoption", referencedColumnName = "id")
    @ManyToOne
    private PostAdoption postAdoption;
    @JoinColumn(name = "story_id", referencedColumnName = "id")
    @ManyToOne
    private Story story;
    @JoinColumns({
        @JoinColumn(name = "service_id", referencedColumnName = "services_id"),
        @JoinColumn(name = "service_person_id", referencedColumnName = "person_id")})
    @ManyToOne
    private ServicosPerson servicosPerson;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "photo")
    private List<Services> servicesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "photo")
    private List<DonationsMade> donationsMadeList;

}