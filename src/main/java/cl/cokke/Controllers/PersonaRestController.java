package cl.cokke.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.cokke.models.Persona;
import cl.cokke.services.PersonaService;

@RestController
@RequestMapping("/api/")
public class PersonaRestController {

	@Autowired
	private PersonaService ps;
	
	@GetMapping("personas")
	public ResponseEntity<List<Persona>> mostrarTodos(){
		
		List<Persona> personas = ps.findAll();
		
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	@GetMapping("personas/{id}")
	public ResponseEntity<Optional<Persona>> buscarPersonaPorId(@PathVariable Long id){
		
		Optional<Persona> personaBuscada = ps.findById(id);
		
		
		return new ResponseEntity<>(personaBuscada, HttpStatus.OK);
	}
	
	@PostMapping("personas")
	public ResponseEntity<Persona> crearPersona(@RequestBody Persona p){
		
		Persona persona = ps.add(p);
		
		return new ResponseEntity<>(persona, HttpStatus.CREATED);
	}
	
	@PutMapping("personas/{id}")
	public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona p){
		
		Optional<Persona> personaBuscada = ps.findById(id);
		
		if(personaBuscada.isPresent()) {
			personaBuscada.get().setNombre(p.getNombre());
			personaBuscada.get().setApellido(p.getApellido());
			personaBuscada.get().setEmail(p.getEmail());
			personaBuscada.get().setFechaNacimiento(p.getFechaNacimiento());
			
			return new ResponseEntity<>(ps.update(personaBuscada.get()), HttpStatus.OK);	
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	
	@DeleteMapping("personas/{id}")
	public ResponseEntity<HttpStatus> eliminarPersona(@PathVariable Long id){
		
		Optional<Persona> personaEliminada = ps.findById(id);
		if(personaEliminada.isPresent()) {
			ps.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);		
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		}
	}
	
	
	
	
	
}
