package com.upeu.cg_matricula.service.impl;

import com.upeu.cg_matricula.entity.Matricula;
import com.upeu.cg_matricula.repository.MatriculaRepository;
import com.upeu.cg_matricula.service.MatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<Matricula> obtenerMatriculaPorId(Long idMatricula) {
        return matriculaRepository.findById(idMatricula);
    }

    @Override
    public Matricula guardarMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula actualizarMatricula(Long idMatricula, Matricula matricula) {
        return matriculaRepository.findById(idMatricula)
                .map(m -> {
                    m.setIdAlumno(matricula.getIdAlumno());
                    m.setIdCurso(matricula.getIdCurso());
                    m.setFecha(matricula.getFecha());
                    return matriculaRepository.save(m);
                })
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));
    }

    @Override
    public void eliminarMatricula(Long idMatricula) {
        matriculaRepository.deleteById(idMatricula);
    }
}
