/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.repositories;

import com.mycompany.lab3.Exam;
import com.mycompany.lab3.Resource;
import com.mycompany.lab3.repositories.interfaces.IExamRepository;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateful
public class ExamRepository {
    
    @PersistenceContext(unitName = "PU")
    EntityManager em;
    
    @EJB
   private ResourceRepository resourceRepository;

    public ExamRepository() {
    }
    
    @Transactional
    public Exam create(Exam exam,String[] chosenResources) {
        List<Resource> resources= resourceRepository.getByDate(exam.getDate());
        
        int roomsCount=0;
        int projectorsCount=0;
        for(Resource res : resources)
        {
            if(res.getName().equals("room"))
                roomsCount++;
            else
                projectorsCount++;
        }
        
        for(String resourceName : chosenResources)
        {
            Resource resource =resourceRepository.getByName(resourceName);
            
            if(resource.getName().equals("room")){
            if(roomsCount>=resource.getNumber())
                return null;
            }
            else
            {
                if(projectorsCount>=resource.getNumber())
                    return null;
            }
            
            exam.getResources().add(resource);
        }
        em.persist(exam);
        em.flush();
        
        //InMemoryMap.addAssignment(exam.getName(),exam.getResources());
        return exam;
    }

    @Transactional
    public Exam getByName(String name) {
        return em.createNamedQuery("Exam.getByName", Exam.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Transactional
    public List<Exam> getAll() {
        return em.createNamedQuery("Exam.getAll", Exam.class)
                .getResultList();
    }

    
    public Exam get(EntityManager em, int id) {
        return null;
    }

    
    public void update(Exam entity) {

    }

}
