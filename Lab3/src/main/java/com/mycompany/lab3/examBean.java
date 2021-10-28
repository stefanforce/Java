/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.lab3;

import com.github.javafaker.Faker;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Stefan
 */
@Named(value = "examBean")
@SessionScoped
public class examBean implements Serializable {

   
    private Exam exam;

    public Exam getExam() {
        return exam;
    }
    
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    
    @PostConstruct
    public void init() {
        exam = new Exam();
    }

    public String insertRow() {
        DBconnection db = new DBconnection();
        Connection conn = db.connect_to_db("postgres", "postgres", "postgres");
        try {
            PreparedStatement ps = conn.prepareStatement("insert into exams (name,date,duration) values(?,?,?);");
            ps.setString(1, exam.name);
            ps.setDate(2, new java.sql.Date(exam.date.getTime()));
            ps.setInt(3, exam.duration);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return "submitExam";
    }
    
    

    public List<Exam> selectNames() {
        DBconnection db = new DBconnection();
        List<Exam> examList = new ArrayList<>();
        Connection conn = db.connect_to_db("postgres", "postgres", "postgres");
        ResultSet rs;
        try {
            String query = "SELECT * FROM exams";
            PreparedStatement state = conn.prepareStatement(query);
            state.execute();
            rs = state.getResultSet();
            while (rs.next()) {

                examList.add(new Exam(rs.getString(1),
                        rs.getDate(2), rs.getInt(3)));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return examList;
    }

     static Faker faker = new Faker();
    private List<Exam> randomExams;
    
    public List<Exam> getRandomExams() {
        if (randomExams == null) {
            createRandomExams();
        }
        return randomExams;
    }

    private void createRandomExams() {
        int n = 100;
        this.randomExams = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Exam e = new Exam();
            e.setName(faker.name().fullName());
            e.setDate(faker.date().birthday());
            e.setDuration(60);
            randomExams.add(e);
        }

    }
}
