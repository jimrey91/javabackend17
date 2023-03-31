package com.evaluacion.repo;

import com.evaluacion.model.Student;

/**
 *
 * @author Reyes
 */
public interface IStudentRepo extends IGenericRepo<Student, Integer>{
    
    /*
    Query order student by age 
    select * from student order by age desc;
    */
    
}
