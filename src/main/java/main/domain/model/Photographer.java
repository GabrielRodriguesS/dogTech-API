package main.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "photographer")
public class Photographer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
    @Column(name = "link_portifolio")
    private String linkPortifolio;
    @OneToMany(mappedBy = "photographerId")
    private List<Photo> photoList;
}