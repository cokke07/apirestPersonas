package cl.cokke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.cokke.models.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
