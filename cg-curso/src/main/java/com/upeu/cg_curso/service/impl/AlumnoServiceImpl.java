package com.upeu.cg_curso.service.impl;

import com.upeu.cg_curso.entity.Alumno;
import com.upeu.cg_curso.repository.AlumnoRepository;
import com.upeu.cg_curso.service.AlumnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Optional<Alumno> obtenerAlumnoPorId(Long idAlumno) {
        return alumnoRepository.findById(idAlumno);
    }

    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno actualizarAlumno(Long idAlumno, Alumno alumno) {
        return alumnoRepository.findById(idAlumno)
                .map(a -> {
                    a.setNombre(alumno.getNombre());
                    a.setApellido(alumno.getApellido());
                    a.setDni(alumno.getDni());
                    a.setEmail(alumno.getEmail());
                    a.setFechaNacimiento(alumno.getFechaNacimiento());
                    return alumnoRepository.save(a);
                })
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
    }

    @Override
    public void eliminarAlumno(Long idAlumno) {
        alumnoRepository.deleteById(idAlumno);
    }
}
