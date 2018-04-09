package main.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "post_adoption")
public class PostAdoption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    private String feedback;
    @Basic(optional = false)
    private int author;
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