package main.domain.repository.generic;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericJpaDao<T extends Serializable> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> clazz;

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(Long id) {
        return this.entityManager.find(this.clazz, id);
    }

    public List findAll() {
        return this.entityManager.createQuery("from " + this.clazz.getName()).getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public T save(T entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T entity) {
        this.entityManager.merge(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(T entity) {
        if (this.entityManager.contains(entity))
            this.entityManager.remove(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(Long entityId) {
        T entity = this.entityManager.find(this.clazz, entityId);
        delete(entity);
    }
}
