package com.bolsadeideas.springboot.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index(){
		return "params/index";
	}
	
	
	@GetMapping("/string")
	public String param(@RequestParam(defaultValue = "no hay saludo") String texto, Model model) {
		model.addAttribute("resultado", "el texto enviado es: " + texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo
			, @RequestParam Integer numero,
			Model model
			) {
					model.addAttribute("resultado", "el saludo enviado es: '" 
					+ saludo + "' y el numero es '" 
					+ numero + "'");
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request,
			Model model
			) {
		String saludo = request.getParameter("saludo");
		//utilizando try, se declara la variable antes del try y dentro se modifica
		Integer numero = null;
		try {
		numero = Integer.parseInt(request.getParameter("numero"));
		} catch(NumberFormatException e) {
			numero = 0;
			//mostrara 0 porque envie un true como valor del param numero en la vista
		}
		model.addAttribute("resultado", "el saludo enviado es: '" 
				+ saludo + "' y el numero es '" 
				+ numero + "'");
		return "params/ver";
	}

}
