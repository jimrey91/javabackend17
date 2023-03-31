package com.evaluacion.service;

import java.util.List;
import java.util.Map;

import com.evaluacion.model.Enrollment;
import com.evaluacion.model.EnrollmentDetail;

/**
 *
 * @author Reyes
 */
public interface IEnrollmentService extends ICRUD<Enrollment, Integer>{
    
    Map<String, List<EnrollmentDetail>> getStudentByCourse();
    
}
