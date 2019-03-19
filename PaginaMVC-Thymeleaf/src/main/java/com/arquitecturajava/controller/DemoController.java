package com.arquitecturajava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arquitecturajava.model.Usuario;

@Controller
public class DemoController {

	@GetMapping
	public String Index(Model model) {
		List<Usuario> lst = new ArrayList<Usuario>();
		lst.add(new Usuario(1, "Usuario1", "Kevin Matos"));
		lst.add(new Usuario(2, "Usuario2", "Pepito Perez"));
		lst.add(new Usuario(3, "Usuario3", "Franco Escamilla"));
		lst.add(new Usuario(4, "Usuario4", "Tavo Morales"));

		model.addAttribute("lstUsuario", lst);

		return "index";
	}
}
