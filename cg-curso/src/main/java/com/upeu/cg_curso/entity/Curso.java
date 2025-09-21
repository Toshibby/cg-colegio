package com.upeu.cg_curso.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(nullable = false, unique = true, length = 20, name = "codigo")
    private String codigo;

    @Column(nullable = false, length = 100, name = "nombre")
    private String nombre;

    @Column(length = 255, name = "descripcion")
    private String descripcion;

    @Column(name = "creditos")
    private Integer creditos;
}
