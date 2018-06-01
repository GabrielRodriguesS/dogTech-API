package main.service;

import main.domain.model.Baia;
import org.springframework.stereotype.Service;

@Service
public class BaiaGenericService {

    private Baia baia;

    public BaiaGenericService() {
        this.baia = new Baia();
    }

//    @Override
//    public Object saveOrUpdate(Object entity) {
//        return this.saveOrUpdate(entity);
//    }
//
//    @Override
//    public List<Object> getAll(Object entity) {
//        return this.getAll(this.baia);
//    }
//
//    @Override
//    public Object getOne(Object entity, Long id) {
//        return this.getOne(this.baia, id);
//    }
//
//    @Override
//    public void remove(Object entity) {
//
//    }
//
//    @Override
//    public void removeById(Object entity, Long id) {
//
//    }
}
