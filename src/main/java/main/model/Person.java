package main.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Long id;
	@Basic(optional = false)
	private String name;
	@Basic(optional = false)
	@Email
	private String email;
	@Basic(optional = false)
	private String password;
	@Basic(optional = false)
	@CPF
	private String cpf;
	@Basic(optional = false)
	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirth;
	@Basic(optional = false)
	private short voluntary;
	private String token;
	@Column(name = "date_token")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateToken;
	@Column(name = "default_password")
	private Short defaultPassword;
	@ManyToMany(mappedBy = "personList")
	private List<Role> roleList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
	private List<Address> addressList;
	@OneToMany(mappedBy = "personId")
	private List<Photo> photoList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
	private List<Telephone> telephoneList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personId1")
	private List<ServicesPerson> servicesPersonList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
	private List<ServiceSuggestion> serviceSuggestionList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adopter")
	private List<Adoption> adoptionList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptionManager")
	private List<Adoption> adoptionList1;
}