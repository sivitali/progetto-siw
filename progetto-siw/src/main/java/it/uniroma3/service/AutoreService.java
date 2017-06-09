package it.uniroma3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import it.uniroma3.modello.Autore;
import it.uniroma3.repository.AutoreRepository;

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
	public void deleteById (Autore autore){
		this.autoreRepository.delete(autore);
	}

}