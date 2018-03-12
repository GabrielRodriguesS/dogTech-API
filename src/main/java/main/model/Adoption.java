package main.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "adoption")
@Data
public class Adoption implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	@Column(name = "date_interest")
	@Temporal(TemporalType.DATE)
	private Date dateInterest;
	@Column(name = "date_adoption")
	@Temporal(TemporalType.DATE)
	private Date dateAdoption;
	@Column(name = "status")
	private String status;
	@OneToMany(mappedBy = "adoption")
	private List<Photo> photoList;
	@JoinColumn(name = "animal_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Animal animal;
	@JoinColumn(name = "adopter", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Person person;
	@JoinColumn(name = "adoption_manager", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Person person1;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adoption")
	private List<EvaluationAdopter> evaluationAdopterList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adoption")
	private List<PostAdoption> postAdoptionList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adoption")
	private List<Visit> visitList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adoption")
	private List<Story> storyList;

}
