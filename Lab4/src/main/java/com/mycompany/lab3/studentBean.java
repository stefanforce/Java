/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.lab3;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Stefan
 */
@Named(value = "studentBean")
@Dependent
public class studentBean implements Serializable {

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private Student student;

    @PostConstruct
    public void init() {
        student = new Student();
    }

}
