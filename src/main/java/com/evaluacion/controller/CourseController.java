package com.evaluacion.controller;

import com.evaluacion.model.Course;
import com.evaluacion.service.ICourseService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Reyes
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    
     private final ICourseService service;
    
    @GetMapping
    public ResponseEntity<List<Course>> readAll() throws Exception{
        
        List<Course> list = service.list().stream().map(e  -> 
            new Course(e.getIdCourse(), e.getName(), e.getAcronym(), e.isEnabled())
                ).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Course> create(@Valid @RequestBody Course student) throws Exception{
            
        Course st = service.save(student);
        return new ResponseEntity<>(st, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@Valid @PathVariable("id") Integer idCourse, @RequestBody Course course) throws Exception{
        course.setIdCourse(idCourse);
        Course st = service.save(course);
        return new ResponseEntity<>(st, HttpStatus.OK);
    }
        
    @DeleteMapping("/{id}")    
    public ResponseEntity<Void> delete(@PathVariable("id") Integer idCourse) throws Exception{
        service.delete(idCourse);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
    
}
