package com.evaluacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Reyes
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;
    
    @Column(nullable = false, length = 50)
    @NotEmpty
    @Size(min= 3, max = 50)
    private String name;
    
    @Column(nullable = false, length = 50)
    @NotEmpty
    @Size(min= 3, max = 50)
    private String lastName;
    
    @Column(nullable = false, length = 8)
    @Size(max = 8)
    @NotEmpty
    private String dni;
    
    @Column(nullable = false)
    @Min(value = 15)
    @Max(value= 99)
    private Integer age;
    
    
}
