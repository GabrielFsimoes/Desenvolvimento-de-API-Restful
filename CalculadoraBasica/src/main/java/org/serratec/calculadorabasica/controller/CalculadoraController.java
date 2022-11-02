package org.serratec.calculadorabasica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculo")
public class CalculadoraController {

	// COM SRINGS OU SEJA, PORTUGOLZADO
//	@GetMapping("/soma")
//	public String soma( @RequestParam Double n1,@RequestParam Double n2) {
//		return "O valor da  soma de "+ n1+ " + " +n2+ " é: " + (n1+n2) ;
//	}
//	
//	@GetMapping("/subtracao")
//	public String subtracao( @RequestParam Double n1, @RequestParam Double n2) {
//		return "O valor da subtração de "+ n1+ " - " +n2+ " é: " + (n1-n2) ;
//	}
//	
//	@GetMapping("/multiplicacao")
//	public String multiplicacao( @RequestParam Double n1, @RequestParam Double n2) {
//		return "O valor da multiplicação de "+ n1+ " x " +n2+ " é: " + (n1*n2) ;
//	}
//	
//	@GetMapping("/divisao")
//	public String divisao( @RequestParam Double n1, @RequestParam Double n2) {
//		if(n1 == 0 || n2 == 0) {
//			return "Não é possivel dividir por zero";
//		}else {
//			return "O valor da divisão de "+ n1+ " / " +n2+ " é: " + (n1/n2) ;
//		}
//	}

	@GetMapping("/soma")
	public Double soma(@RequestParam Double n1, @RequestParam Double n2) {
		return (n1 + n2);
	}
	
	//Metodo com @PathVariable
	@GetMapping("/somaPath/{x}/{y}")
	public Double somap(@PathVariable Double x, @PathVariable Double y) {
		return x+y;
	}
	
	@GetMapping("/subtracao")
	public Double subtracao(@RequestParam Double n1, @RequestParam Double n2) {
		return (n1 - n2);
	}

	@GetMapping("/multiplicacao")
	public Double multiplicacao(@RequestParam Double n1, @RequestParam Double n2) {
		return (n1 * n2);
	}

	@GetMapping("/divisao")
	public Double divisao(@RequestParam Double n1, @RequestParam Double n2) {
		return (n1 / n2);
	}
}
