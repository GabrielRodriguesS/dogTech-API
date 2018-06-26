package main.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(value = {"password"}, allowSetters = true)
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends GenericClass {
    @Basic(optional = false)
    private String name;
    @Email
    @Basic(optional = false)
    private String email;
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Basic(optional = false)
    private String password;
    @CPF
    @Basic(optional = false)
    private String cpf;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
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

    @ManyToMany(mappedBy = "personList", fetch = FetchType.EAGER)
    private Collection<Role> roleList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Address> addressList;

    @OneToMany(mappedBy = "personId")
    private Collection<Photo> photoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Telephone> telephoneList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId1")
    private Collection<ServicesPerson> servicesPersonList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<ServiceSuggestion> serviceSuggestionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adopter")
    private Collection<Adoption> adopterList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private Collection<Adoption> adoptionManagerList;
}