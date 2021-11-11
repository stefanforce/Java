/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.repositories;

import com.mycompany.lab3.Exam;
import com.mycompany.lab3.repositories.interfaces.IExamRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ExamRepository {
    
    @PersistenceContext(unitName = "PU")
    EntityManager em;

    public ExamRepository() {
    }
    
    @Transactional
    public void create(Exam exam) {
        em.persist(exam);
        em.flush();
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
