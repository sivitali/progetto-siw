package it.uniroma3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.modello.Opera;
import it.uniroma3.repository.OperaRepository;

@Service
public class OperaService {
	
	@Autowired
	private OperaRepository operaRepository;
	
	@Transactional
	public void add(final Opera opera){
		this.operaRepository.save(opera);
	}
	
	public Opera findById(Long id){
		return this.operaRepository.findOne(id);
	}
	
	public Iterable<Opera> findAll(){
		return this.operaRepository.findAll();
	}
	
	@Transactional
	public void delete(Opera opera){
		this.operaRepository.delete(opera);
	}
	
}
