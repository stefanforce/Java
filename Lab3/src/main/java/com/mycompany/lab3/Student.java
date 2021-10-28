/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class Student implements Serializable{

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
     * @return the examList
     */
    public List<Exam> getExamList() {
        return examList;
    }

    /**
     * @param examList the examList to set
     */
    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }
    private String name;
    private List<Exam> examList;
    
}
