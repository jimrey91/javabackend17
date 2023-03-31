package com.evaluacion.service;

import java.util.List;

/**
 *
 * @author Reyes
 */
public interface ICRUD<T, ID> {
    
    T save(T t) throws Exception;

    T update(T t, ID id) throws Exception;

    T update(T t, Integer id) throws Exception;

    List<T> list() throws Exception;

    T readById(ID id) throws Exception;

    void delete(ID id) throws Exception;
    
}
