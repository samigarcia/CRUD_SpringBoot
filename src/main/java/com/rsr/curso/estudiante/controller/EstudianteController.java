package com.rsr.curso.estudiante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rsr.curso.estudiante.entity.Estudiante;
import com.rsr.curso.estudiante.service.EstudianteService;

@Controller // <-- GET,PUT,DELETE,POST
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteServ;

	// controladores
	@GetMapping({ "/estudiante", "/" })
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("usuarios", estudianteServ.listarTodosLosUsuarios());
		return "index"; // nos retorna el archivo html que creamos previamente
	}

	@GetMapping({ "/estudiante/nuevo" })
	public String formularioEstudiante(Model modelo) {
		Estudiante estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "crear_estudiante";
	}

	@PostMapping({ "/estudiante" })
	public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		estudianteServ.guardarEstudiante(estudiante);

		return "redirect:/";
	}

	@GetMapping("/estudiante/editar/{id}")
	public String mostrarFromularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudiante", estudianteServ.ObtenerEstudiantePorId(id));
		return "editar_estudiante";
	}

	@PostMapping("/estudiante/{id}")
	public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante,
			Model modelo) {
		Estudiante estudianteExistente = estudianteServ.ObtenerEstudiantePorId(id);
		estudianteExistente.setId(id);
		estudianteExistente.setDireccion(estudiante.getDireccion());
		estudianteExistente.setNombre(estudiante.getNombre());
		estudianteExistente.setTelefono(estudiante.getTelefono());
		estudianteServ.actualizarEstudiante(estudianteExistente);
		return "redirect:/";
	}

	@GetMapping("/estudiante/{id}")
	public String eliminarEstudiante(@PathVariable Long id) {
		estudianteServ.elimninarEstudiante(id);
		return "redirect:/";
	}

}
