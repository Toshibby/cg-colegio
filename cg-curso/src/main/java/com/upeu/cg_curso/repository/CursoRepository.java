package com.upeu.cg_curso.repository;

import com.upeu.cg_curso.entity.Alumno;
import com.upeu.cg_curso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
