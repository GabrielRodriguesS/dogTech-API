package main.service.generic;

import java.util.List;

interface GenericService<E, K> {
    Object saveOrUpdate(Object entity);

    List<Object> getAll(Object entity);

    Object getOne(Object entity, Long id);

    void remove(Object entity);

    void removeById(Object entity, Long id);
}