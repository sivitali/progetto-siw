package it.uniroma3.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.modello.Autore;

public interface AutoreRepository extends CrudRepository <Autore,  Long>{
	
	List<Autore> findByNome (String nome);
	
	List<Autore> findByCognome (String cognome);
	
	List<Autore> findByNazionalita (String nazionalita);
	
	List<Autore> findByDataNascita (Date dataNascita);
	
	

}
