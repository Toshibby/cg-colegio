package com.upeu.cg_matricula.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MatriculaDTO {
    private Long idMatricula;
    private LocalDateTime fecha;

    private AlumnoDTO alumno;
    private CursoDTO curso;
}
