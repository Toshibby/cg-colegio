package com.upeu.cg_matricula.dto;

import lombok.Data;

@Data
public class CursoDTO {
    private Long idCurso;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Integer creditos;
}
