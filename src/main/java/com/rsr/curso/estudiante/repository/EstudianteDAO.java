package com.rsr.curso.estudiante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsr.curso.estudiante.entity.Estudiante;

public interface EstudianteDAO extends JpaRepository <Estudiante, Long> {

}
