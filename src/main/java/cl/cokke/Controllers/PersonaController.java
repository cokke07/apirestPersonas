package cl.cokke.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.cokke.services.PersonaService;

@Controller
@RequestMapping({"/personas","/"})
public class PersonaController {

	@Autowired
	private PersonaService ps;
	
	@GetMapping
	public String portadaWeb(Model model) {
		
		model.addAttribute("saludoInicial", "Bienvenido a la version WEB de Manejo de Personas");
		model.addAttribute("personas", ps.findAll());
		
		return "index";	
	}
	
	
}
