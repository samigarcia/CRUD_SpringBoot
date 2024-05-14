package com.rsr.curso.estudiante.service;

import java.util.List;

import com.rsr.curso.estudiante.entity.Estudiante;

public interface EstudianteServ {

	// otros servicios
	public List<Estudiante> listarTodosLosUsuarios();

	public Estudiante guardarEstudiante(Estudiante estudiante);

	public Estudiante ObtenerEstudiantePorId(Long id);

	public Estudiante actualizarEstudiante(Estudiante estudiante);

	public void elimninarEstudiante(Long id);
}
