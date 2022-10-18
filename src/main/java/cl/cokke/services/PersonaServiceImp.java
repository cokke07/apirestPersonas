package cl.cokke.services;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.cokke.models.Persona;
import cl.cokke.repository.PersonaRepository;

@Service
public class PersonaServiceImp implements PersonaService {

	@Autowired
	private PersonaRepository dao;

	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAll() {
		
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Persona> findById(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public Persona add(Persona p) {
		// TODO Auto-generated method stub
		return dao.save(p);
	}

	@Override
	public Persona update(Persona p) {
		// TODO Auto-generated method stub
		return dao.save(p);
	}

	@Override
	public HttpStatus delete(Long id) {
		Optional<Persona> personaBuscada = dao.findById(id);
		
		if(personaBuscada.isPresent()) {
			dao.deleteById(id);
		}
		return HttpStatus.OK;
	
	}
	
}
