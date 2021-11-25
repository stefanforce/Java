
package com.mycompany.lab3.repositories.interfaces;

import javax.persistence.EntityManager;
import java.util.List;

public interface IRepository<T> {
    
    void create(T entity);

    List<T> getAll();

    T get(EntityManager em, int id);

    void update(T entity);
}
