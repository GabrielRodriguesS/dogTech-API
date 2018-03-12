package main.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ServicosPersonPK implements Serializable {
  
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "services_id")
    private long servicesId;
    @Basic(optional = false)
    @Column(name = "person_id")
    private long personId;
}