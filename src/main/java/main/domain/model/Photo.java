package main.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "photo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Photo extends GenericClass {
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
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
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