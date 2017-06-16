package it.uniroma3.progettosiw.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.progettosiw.model.Autore;
import it.uniroma3.progettosiw.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long>{
	
	List<Opera> findOperaByTitolo(String titolo);
	
	List<Opera> findOperaByAnno(int anno);
	
	List<Opera> findOperaByTecnica(String tecnica);
	
	List<Opera> findOperaByAutore(Autore autore);
	
}