package com.upeu.cg_curso.service;

import com.upeu.cg_curso.entity.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    // Listar todos los alumnos
    List<Alumno> listarAlumnos();

    // Obtener un alumno por ID
    Optional<Alumno> obtenerAlumnoPorId(Long idAlumno);

    // Guardar un nuevo alumno
    Alumno guardarAlumno(Alumno alumno);

    // Actualizar un alumno existente
    Alumno actualizarAlumno(Long idAlumno, Alumno alumno);

    // Eliminar un alumno por ID
    void eliminarAlumno(Long idAlumno);
}
