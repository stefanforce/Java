
package com.mycompany.lab3.services;
import com.mycompany.lab3.Exam;
import com.mycompany.lab3.repositories.ExamRepository;
import com.mycompany.lab3.repositories.interfaces.IExamRepository;
import com.mycompany.lab3.services.interfaces.IExamServices;
import java.util.Date;
import javax.inject.Inject;

/**
 *
 * @author Stefan
 */
public class ExamServices{
    @Inject
    private ExamRepository examRepository;
    
    public void add(String name,Date date,int duration) {
        Exam exam = new Exam(name, date, duration);
        examRepository.create(exam);
    }
    
}
