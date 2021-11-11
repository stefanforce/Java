/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.lab3;

import com.mycompany.lab3.repositories.ExamRepository;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import com.mycompany.lab3.repositories.interfaces.IExamRepository;
import com.mycompany.lab3.services.ExamServices;
import com.mycompany.lab3.services.interfaces.IExamServices;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

/**
 *
 * @author Stefan
 */
@Named(value = "examBean")
@SessionScoped
public class examBean implements Serializable {




     @Resource(mappedName = "jdbc/lab3")
     private DataSource ds;
//     @Inject
//   private ExamServices examServices;
     @Inject
   private ExamRepository examRepository;

    private Exam exam;
    
    public String addExam(){
        examRepository.create(exam);
        return "submitExam";
    }
   
    public examBean(){
    this.exam=new Exam();}

    public List<Exam> displayExams() {
        return examRepository.getAll();
    }
    
  

//    public String insertRow() {
////        DBconnection db = new DBconnection();
////        Connection conn = db.connect_to_db("postgres", "postgres", "postgres");
//        
//        try {
//            Connection conn=ds.getConnection();
//            PreparedStatement ps = conn.prepareStatement("insert into exams (name,date,duration) values(?,?,?);");
//            ps.setString(1, exam.name);
//            ps.setDate(2, new java.sql.Date(exam.date.getTime()));
//            ps.setInt(3, exam.duration);
//            ps.executeUpdate();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return "submitExam";
//    }
    
    

    public List<Exam> selectNames() {
//        DBconnection db = new DBconnection();
//        Connection conn = db.connect_to_db("postgres", "postgres", "postgres");
        List<Exam> examList = new ArrayList<>();
        
       
        ResultSet rs;
        try {
            
             Connection conn=ds.getConnection();
            String query = "SELECT * FROM exams";
            PreparedStatement state = conn.prepareStatement(query);
            state.execute();
            rs = state.getResultSet();
            while (rs.next()) {

                examList.add(new Exam(rs.getString(2),
                        rs.getDate(3), rs.getInt(4)));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return examList;
    }
        public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

}
