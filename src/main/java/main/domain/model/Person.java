package main.domain.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import main.domain.model.Generic.GenericClass;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name = "person")
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends GenericClass {
    @Basic(optional = false)
    private String name;
    @Email
    @Basic(optional = false)
    private String email;
    @JsonIgnore
    @Basic(optional = false)
    private String password;
    @CPF
    @Basic(optional = false)
    private String cpf;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
    @Basic(optional = false)
    private boolean voluntary;
    @JsonIgnore
    private String token;
    @JsonIgnore
    @Column(name = "date_token")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateToken;
    @Column(name = "default_password")
    private boolean defaultPassword;

    @JsonManagedReference
    @ManyToMany(mappedBy = "personList", fetch = FetchType.EAGER)
    private Collection<Role> roleList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Address> addressList;

    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "personId")
    private Collection<Photo> photoList;

    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Telephone> telephoneList;

    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId1")
    private Collection<ServicesPerson> servicesPersonList;

    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<ServiceSuggestion> serviceSuggestionList;

    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adopter")
    private Collection<Adoption> adopterList;

    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private Collection<Adoption> adoptionManagerList;
}