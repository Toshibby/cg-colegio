package com.upeu.cg_matricula.service;

import com.upeu.cg_matricula.dto.MatriculaDTO;
import com.upeu.cg_matricula.entity.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {

    // Listar todas las matrículas
    List<Matricula> listarMatriculas();

    // Obtener una matrícula por ID
    Optional<Matricula> obtenerMatriculaPorId(Long idMatricula);

    // Guardar una nueva matrícula
    Matricula guardarMatricula(Matricula matricula);

    // Actualizar una matrícula existente
    Matricula actualizarMatricula(Long idMatricula, Matricula matricula);

    // Eliminar una matrícula por ID
    void eliminarMatricula(Long idMatricula);

    MatriculaDTO obtenerMatriculaConDetalles(Long idMatricula);
}
