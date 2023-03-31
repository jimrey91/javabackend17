package com.evaluacion.service.impl;

import com.evaluacion.model.Course;
import com.evaluacion.repo.ICourseRepo;
import com.evaluacion.repo.IGenericRepo;
import com.evaluacion.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Reyes
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements  ICourseService{

    private final ICourseRepo repo;
    
    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }
    
}
