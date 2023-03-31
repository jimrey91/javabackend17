package com.evaluacion.repo;

import com.evaluacion.model.Enrollment;

/**
 *
 * @author Reyes
 */
public interface IEnrollmentRepo extends IGenericRepo<Enrollment, Integer>{
    
    /*
    select s.name || ' ' || s.last_name as "student", co.name as "course" from enrollment en 
    join enrollment_detail endet on en.id_enrollment = endet.id_enrollment
    join student s on en.id_student = s.id_student
    join course co on endet.id_course = co.id_course group by s.name, s.last_name, co.name;
    
    
    */
}
