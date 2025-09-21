package com.upeu.cg_matricula.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "matricula")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long idMatricula;

    @Column(name = "id_alumno", nullable = false)
    private Long idAlumno;

    @Column(name = "id_curso", nullable = false)
    private Long idCurso;

    @Column(name = "fecha_matricula")
    private LocalDateTime fecha = LocalDateTime.now();
}
