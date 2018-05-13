package main.domain.model;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ServicesPersonPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "services_id")
    private long servicesId;
    @Basic(optional = false)
    @Column(name = "person_id")
    private long personId;
}