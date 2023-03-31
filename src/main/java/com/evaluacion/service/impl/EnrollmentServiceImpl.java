package com.evaluacion.service.impl;

import com.evaluacion.model.Enrollment;
import com.evaluacion.model.EnrollmentDetail;
import com.evaluacion.model.Student;
import com.evaluacion.repo.IEnrollmentRepo;
import com.evaluacion.repo.IGenericRepo;
import com.evaluacion.service.IEnrollmentService;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Reyes
 */
@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl  extends CRUDImpl <Enrollment, Integer> implements  IEnrollmentService{
    
    private final IEnrollmentRepo repo;

    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, List<EnrollmentDetail>> getStudentByCourse() {
        
        Stream<List<EnrollmentDetail>> stream= repo.findAll().stream().map(Enrollment::getDetails);
        
        Stream<EnrollmentDetail> streamDetail = stream.flatMap(list -> list.stream());
        
       // Stream<String> stream2 = repo.findAll().stream().map(e -> e.getStudent().getName() + e.getStudent().getLastName());
        Map<String, List<EnrollmentDetail>> byCourse = streamDetail.collect(groupingBy(en -> en.getCourse().getName()));
        
        return byCourse; 
    }
    
}
