package main.domain.model;

import lombok.Data;
import main.domain.model.Generic.GenericClass;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "story")
@Inheritance(strategy = InheritanceType.JOINED)
public class Story extends GenericClass {
    private String text;
    private boolean approved;
    @OneToMany(mappedBy = "storyId")
    private List<Photo> photoList;
    @JoinColumn(name = "adoption_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Adoption adoptionId;
}