package com.bolsadeideas.springboot.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.app.models.Usuario;


@Controller 				//componente de tipo de controlador que sera manejado dentro de spring framework
@RequestMapping("/app") 	//ruta de primer nivel
public class IndexController {
	/* un Componente controller puede tener varios metodos */
	
	
	
	@GetMapping({"/", "/index", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Spring Framework"); // de esta manera se pasa informacion a la vista
		return "index";
	}
	
	
	@RequestMapping("/perfil")			// por defecto @RequestMapping tiene asociada una solicitud get
	public String perfil(Model model) {
		Usuario usuario = new Usuario();	//se instancia un nuevo Usuario en blanco
		usuario.setNombre("Alfredo");		//se agrega valor con setNombre al new Usuario
		usuario.setApellido("Supanta");		//se agrega valor con setApellido al new Usuario
		usuario.setEmail("alfredo@gmail.com");		//se agrega valor con setEmail al new Usuario
		model.addAttribute("usuario", usuario); // se define a la izquierda el nombre para llamar, derecha el contenido
		model.addAttribute("titulo", "Perfil de usuario: ".concat(usuario.getNombre()));
		return "perfil";					// retorna la vista perfil
	}
	
	@RequestMapping("/listar")
	public String listar(Model model){
		
		/*List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Marcelo", "Alave", "marcelo@hotmail.com"));
		usuarios.add(new Usuario("Cristian", "Leal", "cristian@hotmail.com"));
		usuarios.add(new Usuario("Javier", "Java", "Jean@hotmail.com"));*/
		
		
		
		
		model.addAttribute("titulo", "Listado de usuarios");
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
	
		// Es mejor de esta manera agregar elementos al array con Arrays.asList()
		
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Marcelo", "Alave", "marcelo@hotmail.com"),
				new Usuario("Cristian", "Leal", "cristian@hotmail.com"),
				new Usuario("Javier", "Java", "jean@hotmail.com"),
				new Usuario("Samuel", "Escobar", "samuel@hotmail.com")
				);
		return usuarios;
	}

}
