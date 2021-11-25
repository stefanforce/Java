/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "exams")
@NamedQueries({
    @NamedQuery(name = "Exam.getByName", query = "select ex from Exam ex where ex.name = :name"),
    @NamedQuery(name = "Exam.getAll", query = "select ex from Exam ex")
})
public class Exam implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @Column(name = "duration")
    private int duration;
    
    @ManyToMany
    @JoinTable(name="examReservations",
            joinColumns= @JoinColumn(name="examid"),
            inverseJoinColumns= @JoinColumn(name="resourceid")
            ) 
    private List<Resource> resources;

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Resource> getResources() {
        return resources;
    }

    

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public Exam(String name, Date date, int duration) {
        this.name = name;
        this.date = date;
        this.duration = duration;
        resources= new ArrayList<>();
    }

    public Exam() {
    }

    public Exam(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
