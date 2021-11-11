/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.repositories.interfaces;

import com.mycompany.lab3.Exam;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Stefan
 */
public interface IExamRepository extends IRepository<Exam> {
       
    Exam getByName(String name);
    List<Exam> getAll();
}
