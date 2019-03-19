package com.arquitecturajava.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arquitecturajava.Entity.Usuario;
import com.arquitecturajava.Repository.UsuarioRepositorio;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepositorio repositorio;

	@GetMapping
	public String Index(Model model, Usuario usua) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", repositorio.findAll());
		return "Index";
	}

	@PostMapping("/crearUsuario")
	public String crearUsuario(Model model, Usuario usua) {
		repositorio.save(usua);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", repositorio.findAll());
		return "Index";
	}

	@GetMapping("/editarUsuario/{Id}")
	public String editarUsuario(Model model, @PathVariable(name = "Id") Integer Id) {
		Usuario usuarioEditar = repositorio.findById(Id).get();
		model.addAttribute("usuario", usuarioEditar);
		model.addAttribute("usuarios", repositorio.findAll());
		return "Index";
	}

	@GetMapping("/eliminarUsuario/{Id}")
	public String eliminarUsuario(Model model, @PathVariable(name = "Id") Integer Id) {
		Usuario usuarioEliminar = repositorio.findById(Id).get();
		repositorio.delete(usuarioEliminar);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", repositorio.findAll());
		return "Index";
	}
}
