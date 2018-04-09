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

import lombok.Data;

@Entity
@Table(name = "person")
@Data
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic(optional = false)
	private String name;
	@Basic(optional = false)
	private String email;
	@Basic(optional = false)
	private String password;
	@Basic(optional = false)
	private String cpf;
	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Basic(optional = false)
	private short voluntario;
	private String token;
	@Column(name = "date_token")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateToken;
	@Column(name = "default_password")
	private Short defaultPassword;
	@ManyToMany(mappedBy = "personList")
	private List<Role> roleList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private List<Address> addressList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private List<ServicosPerson> servicosPersonList;
	@OneToMany(mappedBy = "person")
	private List<Photo> photoList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private List<Telephone> telephoneList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private List<Adoption> adoptionList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person1")
	private List<Adoption> adoptionList1;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "person")
	private List<SuggestionService> suggestionServices;

}