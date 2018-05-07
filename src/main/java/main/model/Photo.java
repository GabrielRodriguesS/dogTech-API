package main.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "photo")
public class Photo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "real_path")
    private String realPath;
    @Column(name = "path_thumbnail")
    private String pathThumbnail;
    @Column(name = "photo_link")
    private String photoLink;
    @JoinColumn(name = "adoption_id", referencedColumnName = "id")
    @ManyToOne
    private Adoption adoptionId;
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    @ManyToOne
    private Animal animalId;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne
    private Person personId;
    @JoinColumn(name = "photographer_id", referencedColumnName = "id")
    @ManyToOne
    private Photographer photographerId;
    @JoinColumn(name = "post_adoption_id", referencedColumnName = "id")
    @ManyToOne
    private PostAdoption postAdoptionId;
    @JoinColumns({
        @JoinColumn(name = "services_person_services_id", referencedColumnName = "services_id"),
        @JoinColumn(name = "services_person_person_id", referencedColumnName = "person_id")})
    @ManyToOne
    private ServicesPerson servicesPerson;
    @JoinColumn(name = "story_id", referencedColumnName = "id")
    @ManyToOne
    private Story storyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "photoId")
    private List<Services> servicesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "photoId")
    private List<DonationsMade> donationsMadeList;
}