package com.upeu.cg_matricula.feign;

import com.upeu.cg_matricula.dto.AlumnoDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cg-curso", path = "/alumnos", contextId = "alumnoFeignClient")
public interface AlumnoFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "alumnoListarPorIdCB", fallbackMethod = "fallbackAlumno")
    public AlumnoDTO buscarPorId(@PathVariable Long id);

    default AlumnoDTO fallbackAlumno(Long id, Exception e) {
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setIdAlumno(9000000L);
        alumnoDTO.setNombre("Servicios de alumno no  disponible");
        return alumnoDTO;
    }

}
