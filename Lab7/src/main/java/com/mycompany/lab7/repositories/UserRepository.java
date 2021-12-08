package com.mycompany.lab7.repositories;

import com.mycompany.lab7.user.User;
import com.mycompany.lab7.repositories.interfaces.IUserRepository;

import javax.persistence.EntityManager;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Produces;

@ApplicationScoped
public class UserRepository implements IUserRepository {
    
    @PersistenceContext(unitName = "PU")
    EntityManager em;

    public UserRepository() {
    }
    
    @Transactional
    @Override
    public void create(User user) {
        em.persist(user);
        em.flush();
    }

    @Transactional
    @Override
    public User getByEmail(String email) {
        try{
            User userToReturn = em.createNamedQuery("User.getByEmail", User.class)
                .setParameter("email", email)
                .getSingleResult();
            return userToReturn;
        } catch(Exception ex) {
            return null;
        }
    }

    @Override
    public List<User> getAll(EntityManager em) {
        return em.createNamedQuery("User.getAll", User.class)
                .getResultList();
    }

    @Override
    public User get(EntityManager em, int id) {
        return null;
    }

    @Override
    public void update(User entity) {

    }



}
