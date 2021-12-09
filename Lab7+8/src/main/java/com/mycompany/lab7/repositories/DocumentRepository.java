package com.mycompany.lab7.repositories;

import com.mycompany.lab7.user.User;

import javax.persistence.EntityManager;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.mycompany.lab7.document.Document;
import com.mycompany.lab7.repositories.interfaces.IDocumentRepository;
import com.mycompany.lab7.repositories.interfaces.IRepository;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;

@ApplicationScoped
public class DocumentRepository implements IDocumentRepository{
    
    @PersistenceContext(unitName = "PU")
    EntityManager em;

    @Transactional
    public void create(Document event) {
        em.persist(event);
        em.flush();
    }

    @Transactional
    public Document getByName(String name) {
        return em.createNamedQuery("Document.getByName", Document.class)
                .setParameter("name", name)
                .getSingleResult();
    }
    
    @Transactional
    public Document getByCalendarId(Document document) {
        return em.createNamedQuery("Document.getById", Document.class)
                .setParameter("document", document)
                .getSingleResult();
    }

    
    public List<Document> getAll(EntityManager em) {
        return em.createNamedQuery("CalendarEntries.getAll", Document.class)
                .getResultList();
    }
    
    public Document get(EntityManager em, int id) {
        return null;
    }
    public void update(Document entity) {

    }


}
