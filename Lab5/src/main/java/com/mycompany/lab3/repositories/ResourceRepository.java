/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.repositories;

import com.mycompany.lab3.Resource;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ResourceRepository {
    @PersistenceContext(unitName = "PU")
    EntityManager em;
    
    public List<Resource> get(){ return em.createNamedQuery("Resources.all",Resource.class)
            .getResultList();
    }
    
    public Resource getByName(String name){
        return em.createNamedQuery("Resources.byName",Resource.class)
            .setParameter("name",name)
            .getResultList()
            .get(0);
    }
    
    public List<Resource> getByDate(Date date){
    return em.createNamedQuery("Resources.byDate",Resource.class)
            .setParameter("date",date)
            .getResultList();
    }

    
}
