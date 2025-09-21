package com.upeu.cg_curso.service;

import com.upeu.cg_curso.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    // Listar todos los cursos
    List<Curso> listarCursos();

    // Obtener un curso por ID
    Optional<Curso> obtenerCursoPorId(Long idCurso);

    // Guardar un nuevo curso
    Curso guardarCurso(Curso curso);

    // Actualizar un curso existente
    Curso actualizarCurso(Long idCurso, Curso curso);

    // Eliminar un curso por ID
    void eliminarCurso(Long idCurso);
}
