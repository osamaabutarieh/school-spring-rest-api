package com.osama.project.school_rest_api.service;

import java.util.List;

public interface CrudService<E,K> {

    List<E> findAll();

    E  findById(K id);

    E save(E entity);

    void delete(K id);

}
