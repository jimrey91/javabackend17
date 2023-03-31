package com.evaluacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;
    
    @Column(nullable = false, length = 50)
    @NotEmpty
    @Size(min = 10, max = 50)
    private String name;
    
    @Column(nullable = false, length= 10)
    @NotEmpty
    @Size(min = 1, max = 10)
    private String acronym;
    
    @Column(nullable = false)
    @NotNull
    private boolean enabled;
    
}
