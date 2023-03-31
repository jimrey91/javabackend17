package com.evaluacion.controller;

import com.evaluacion.model.Enrollment;
import com.evaluacion.model.EnrollmentDetail;
import com.evaluacion.service.IEnrollmentService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    
    private final IEnrollmentService service;
    
    @GetMapping
    public ResponseEntity<List<Enrollment>> readAll() throws Exception{
        
        List<Enrollment> list = service.list().stream().map(e  -> 
            new Enrollment(e.getIdEnrollment(), e.getDatetime(), e.getStudent(), e.isEnabled(), e.getDetails())
                ).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Enrollment> create(@Valid @RequestBody Enrollment student) throws Exception{
            
        Enrollment st = service.save(student);
        return new ResponseEntity<>(st, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> update(@Valid @PathVariable("id") Integer idEnrollment, @RequestBody Enrollment enrollment) throws Exception{
        enrollment.setIdEnrollment(idEnrollment);
        Enrollment st = service.save(enrollment);
        return new ResponseEntity<>(st, HttpStatus.OK);
    }
        
    @DeleteMapping("/{id}")    
    public ResponseEntity<Void> delete(@PathVariable("id") Integer idEnrollment) throws Exception{
        service.delete(idEnrollment);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
   
    @GetMapping("/enrollstudents")
    public ResponseEntity<Map<String, List<EnrollmentDetail>>> getStudentByCourse(){
        Map<String, List<EnrollmentDetail>> map = service.getStudentByCourse();
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
   /*  */
}
