package main.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "post_adoption")
public class PostAdoption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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