package com.upeu.cg_curso.service.impl;

import com.upeu.cg_curso.entity.Curso;
import com.upeu.cg_curso.repository.CursoRepository;
import com.upeu.cg_curso.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> obtenerCursoPorId(Long idCurso) {
        return cursoRepository.findById(idCurso);
    }

    @Override
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso actualizarCurso(Long idCurso, Curso curso) {
        return cursoRepository.findById(idCurso)
                .map(c -> {
                    c.setCodigo(curso.getCodigo());
                    c.setNombre(curso.getNombre());
                    c.setDescripcion(curso.getDescripcion());
                    c.setCreditos(curso.getCreditos());
                    return cursoRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    @Override
    public void eliminarCurso(Long idCurso) {
        cursoRepository.deleteById(idCurso);
    }
}
