package cl.cokke.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import cl.cokke.models.Persona;

public interface PersonaService {

	public List<Persona> findAll();
	public Optional<Persona> findById(Long id);
	public Persona add(Persona p);
	public Persona update(Persona p);
	public HttpStatus delete(Long id);
	
}
