package com.mycompany.lab7.repositories.interfaces;

import javax.persistence.EntityManager;
import java.util.List;

public interface IRepository<T> {
    
    void create(T entity);

    List<T> getAll(EntityManager em);

    T get(EntityManager em, int id);

    void update(T entity);
}
