package com.vmatosse.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {
	
	@RequestMapping("/saludar")
	public String Saludar() {
		return "Hola Mundo";
	}
}
