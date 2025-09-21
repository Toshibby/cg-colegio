package com.upeu.cg_matricula.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class AlumnoDTO {
    private Long idAlumno;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private Date fechaNacimiento;
}
