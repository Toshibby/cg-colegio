package com.upeu.cg_matricula.feign;

import com.upeu.cg_matricula.dto.CursoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cg-curso", path = "/cursos", contextId = "cursoFeignClient")
public interface CursoFeign {
    @GetMapping("/{id}")
    public CursoDTO buscarPorId(@PathVariable Long id);
}
