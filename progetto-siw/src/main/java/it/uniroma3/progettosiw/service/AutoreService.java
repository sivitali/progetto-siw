package it.uniroma3.progettosiw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.progettosiw.model.Autore;
import it.uniroma3.progettosiw.repository.AutoreRepository;

@Service
public class AutoreService {

	@Autowired
	private AutoreRepository autoreRepository; 


	public Autore findById (Long id){
		return this.autoreRepository.findOne(id);
	}
	public Iterable<Autore> findAll() {
		return this.autoreRepository.findAll();
	}
	
	@Transactional
	public void add(final Autore autore) {
		this.autoreRepository.save(autore);
	}

	@Transactional
	public void deleteById (Long id){
		this.autoreRepository.delete(id);
	}

}