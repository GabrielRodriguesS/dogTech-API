package main.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private boolean voluntary;
	private String token;
	@Column(name = "date_token")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateToken;
	@Column(name = "default_password")
    private boolean defaultPassword;
	@ManyToMany(mappedBy = "personList")
	private List<Role> roleList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
	@JsonManagedReference
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
    private List<Adoption> adopterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private List<Adoption> adoptionManagerList;
}