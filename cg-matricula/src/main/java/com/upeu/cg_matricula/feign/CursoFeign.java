package com.upeu.cg_matricula.feign;

import com.upeu.cg_matricula.dto.AlumnoDTO;
import com.upeu.cg_matricula.dto.CursoDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cg-curso", path = "/cursos", contextId = "cursoFeignClient")
public interface CursoFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "cursoListarPorIdCB", fallbackMethod = "fallbackCurso")
    public CursoDTO buscarPorId(@PathVariable Long id);

    default CursoDTO fallbackCurso(Long id, Exception e) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setIdCurso(9000000L);
        cursoDTO.setNombre("Servicios de curso no  disponible");
        return cursoDTO;
    }
}
