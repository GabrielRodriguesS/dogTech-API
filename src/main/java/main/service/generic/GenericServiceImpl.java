package main.service.generic;

import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImpl<E, K> implements GenericService<E, K> {

//    @Autowired
//    private AbstractJpaDao genericRepository;

//    @Transactional(propagation = Propagation.REQUIRED)
//    public Object saveOrUpdate(Object entity) {
//        return this.genericRepository.save(entity);
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
//    public List<Object> getAll(Object entity) {
//        return this.genericRepository.findAll(Example.of(entity));
//    }

//    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
//    public Object getOne(E entity, K id) {
//        return this.genericRepository.getOne(id));
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void delete(Object entity) {
//        this.genericRepository.delete(entity);
//    }

//    @Transactional(propagation = Propagation.REQUIRED)
//    public void removeById(Object entity, Long id) {
//        this.genericRepository.deleteById(entity, id);
//    }
}
