package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "post_adoption")
@Inheritance(strategy = InheritanceType.JOINED)
public class PostAdoption extends GenericClass {
    private String feedback;
    @Basic(optional = false)
    private Long author;
    @OneToMany(mappedBy = "postAdoptionId")
    private List<Photo> photoList;
    @JoinColumn(name = "adoption_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Adoption adoptionId;
    @OneToMany(mappedBy = "postAdoptionId")
    private List<PostAdoption> postAdoptionList;
    @JoinColumn(name = "post_adoption_id", referencedColumnName = "id")
    @ManyToOne
    private PostAdoption postAdoptionId;
}