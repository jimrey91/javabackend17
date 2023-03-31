package com.evaluacion.controller;

import com.evaluacion.model.Student;
import com.evaluacion.service.IStudentService;
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
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    
    private final IStudentService service;
    
    @GetMapping
    public ResponseEntity<List<Student>> readAll() throws Exception{
        
        List<Student> list = service.list().stream().map(e  -> 
            new Student(e.getIdStudent(), e.getName(), e.getLastName(), e.getDni(), e.getAge())
                ).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/listage")
    public ResponseEntity<List<Student>> getStudentByAge(){
        List<Student> listStudent  = service.getStudentByAge();
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody Student student) throws Exception{
            
        Student st = service.save(student);
        return new ResponseEntity<>(st, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@Valid @PathVariable("id") Integer idStudent, @RequestBody Student student) throws Exception{
        student.setIdStudent(idStudent);
        Student st = service.save(student);
        return new ResponseEntity<>(st, HttpStatus.OK);
    }
        
    @DeleteMapping("/{id}")    
    public ResponseEntity<Void> delete(@PathVariable("id") Integer idStudent) throws Exception{
        service.delete(idStudent);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
    
    
    
    
}
