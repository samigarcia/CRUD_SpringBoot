package com.rsr.curso.estudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsr.curso.estudiante.service.EstudianteService;
import com.rsr.curso.estudiante.entity.Estudiante;
import com.rsr.curso.estudiante.repository.EstudianteDAO;

import jakarta.transaction.Transactional;

@Service
public class EstudianteService implements EstudianteServ {

	@Autowired
	private EstudianteDAO estudianteDao;

	// obtiene todos los datos del usuario
	@Transactional
	public List<Estudiante> findAll() {
		return (List<Estudiante>) estudianteDao.findAll();
	}

	// guardar usuario
	@Transactional
	public Estudiante save(Estudiante estudiante) {

		return estudianteDao.save(estudiante);
	}

	// busqueda por id
	public Estudiante findById(Long id) {
		return estudianteDao.findById(id).orElse(null);
	}

	// elimninar usuario
	@Transactional
	public void delete(Long id) {

		estudianteDao.deleteById(id);
	}

	// otros servicios
	@Override
	public List<Estudiante> listarTodosLosUsuarios() {

		return estudianteDao.findAll();
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return estudianteDao.save(estudiante);
	}

	@Override
	public Estudiante ObtenerEstudiantePorId(Long id) {
		return estudianteDao.findById(id).get();
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		return estudianteDao.save(estudiante);
	}

	@Override
	public void elimninarEstudiante(Long id) {
		estudianteDao.deleteById(id);
	}

}
