package com.upeu.cg_curso.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long idAlumno;

    @Column(nullable = false, length = 100, name = "nombre")
    private String nombre;

    @Column(nullable = false, length = 100, name = "apellido")
    private String apellido;

    @Column(nullable = false, unique = true, length = 20, name = "dni")
    private String dni;

    @Column(unique = true, length = 100, name = "email")
    private String email;

    @Column(name = "fecha_nacimiento")
    private java.sql.Date fechaNacimiento;
}
