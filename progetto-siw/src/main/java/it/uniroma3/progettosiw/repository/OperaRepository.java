package it.uniroma3.progettosiw.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.progettosiw.model.Autore;
import it.uniroma3.progettosiw.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long>{
	
	List<Opera> findByTitolo(String titolo);
	
	List<Opera> findByAnno(int anno);
	
	List<Opera> findByTecnica(String tecnica);
	
	List<Opera> findByAutore(Autore autore);
	
}