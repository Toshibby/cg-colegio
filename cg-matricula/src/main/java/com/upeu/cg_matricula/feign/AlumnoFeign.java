package com.upeu.cg_matricula.feign;

import com.upeu.cg_matricula.dto.AlumnoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cg-curso", path = "/alumnos", contextId = "alumnoFeignClient")
public interface AlumnoFeign {
    @GetMapping("/{id}")
    public AlumnoDTO buscarPorId(@PathVariable Long id);
}
