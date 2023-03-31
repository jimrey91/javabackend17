package com.evaluacion.service.impl;

import com.evaluacion.model.Student;
import com.evaluacion.repo.IGenericRepo;
import com.evaluacion.repo.IStudentRepo;
import com.evaluacion.service.IStudentService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Reyes
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService{
    
    private final IStudentRepo repo;
    
    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> getStudentByAge() {
        return repo.findAll().stream()
                                        .sorted(Comparator.comparing(Student::getAge).reversed())
                                        .collect(Collectors.toList());
    }
    
}
