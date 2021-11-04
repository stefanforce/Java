/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Stefan
 */
public class Exam implements Serializable {

    public String name;
    public Date date;
    public int duration;

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

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Exam(String name, Date date, int duration) {
        this.name = name;
        this.date = date;
        this.duration = duration;
    }

    public Exam() {
    }

    public Exam(String name) {
        this.name = name;
    }

}
