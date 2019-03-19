package com.arquitecturajava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String Index() {
		return "Index";
	}

	@GetMapping("/login")
	public String Login() {
		return "LoginForm";
	}

	@PostMapping("/login")
	public String LoginForm(Model model, Usuario usuario) {
		String resultado = "";
		if (usuario.getUsuario().isEmpty() || usuario.getContrasena().isEmpty()) {
			resultado = "Fallido ambos campos son obligatorios";
		} else {
			resultado = "Yeah puedes entrar";
		}		
		model.addAttribute("result", resultado);
		return "Menu";
	}
}
