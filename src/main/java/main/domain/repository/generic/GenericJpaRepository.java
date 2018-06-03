package main.domain.repository.generic;

import main.domain.model.Generic.GenericClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface GenericJpaRepository<T extends GenericClass> extends JpaRepository<T, Serializable> {

}
