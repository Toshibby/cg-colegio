package com.upeu.cg_matricula.service.impl;

import com.upeu.cg_matricula.dto.AlumnoDTO;
import com.upeu.cg_matricula.dto.CursoDTO;
import com.upeu.cg_matricula.dto.MatriculaDTO;
import com.upeu.cg_matricula.entity.Matricula;
import com.upeu.cg_matricula.feign.AlumnoFeign;
import com.upeu.cg_matricula.feign.CursoFeign;
import com.upeu.cg_matricula.repository.MatriculaRepository;
import com.upeu.cg_matricula.service.MatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlumnoFeign alumnoFeign;
    private final CursoFeign cursoFeign;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository,
                                AlumnoFeign alumnoFeign,
                                CursoFeign cursoFeign) {
        this.matriculaRepository = matriculaRepository;
        this.alumnoFeign = alumnoFeign;
        this.cursoFeign = cursoFeign;
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

    // 🚀 Nuevo método que devuelve la matrícula con datos completos
    public MatriculaDTO obtenerMatriculaConDetalles(Long idMatricula) {
        Matricula matricula = matriculaRepository.findById(idMatricula)
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));

        // Consumir microservicios
        AlumnoDTO alumno = alumnoFeign.buscarPorId(matricula.getIdAlumno());
        CursoDTO curso = cursoFeign.buscarPorId(matricula.getIdCurso());

        // Armar DTO manualmente
        MatriculaDTO dto = new MatriculaDTO();
        dto.setIdMatricula(matricula.getIdMatricula());
        dto.setFecha(matricula.getFecha());
        dto.setAlumno(alumno);
        dto.setCurso(curso);

        return dto;
    }
}
