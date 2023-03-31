package com.evaluacion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDetail {
    
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnrollmentDetail;
    
    @ManyToOne
    @JoinColumn(name = "id_enrollment", nullable = false, foreignKey = @ForeignKey(name= "FK_Detail_Enrollment"))
    @JsonBackReference
    @NotNull
    private Enrollment enrollment;
    
    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name= "FK_Detail_Course"))
    @NotNull
    private Course course;
    
    @Column(nullable = false, length= 10)
    @NotEmpty
    @Size(min = 1, max = 10)
    private String classroom;
    
}
