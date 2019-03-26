package restful.calculadora.restful.calculadora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@GetMapping(path = "/suma/{num1}/{num2}")
	public String Sumar(@PathVariable String num1, @PathVariable String num2) {
		return "Opcion Sumar => La suma es : " + (Integer.parseInt(num1) + Integer.parseInt(num2));
	}

	@GetMapping(path = "/resta/{num1}/{num2}")
	public String Restar(@PathVariable String num1, @PathVariable String num2) {
		return "Opcion Restar => La resta es : " + (Integer.parseInt(num1) - Integer.parseInt(num2));
	}
	
	@GetMapping("/multiplicar")
	public String Muliplicar(@RequestParam(value="num1") int num1,@RequestParam(value="num2") int num2) {
		return "Opcion multiplicacion => La multiplicacion es : " + (num1 * num2);
	}
}
