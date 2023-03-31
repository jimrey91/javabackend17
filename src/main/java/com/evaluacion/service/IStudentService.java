package com.evaluacion.service;

import com.evaluacion.model.Student;
import java.util.List;

/**
 *
 * @author Reyes
 */
public interface IStudentService extends ICRUD<Student, Integer>{
    
    List<Student> getStudentByAge();
    
}
