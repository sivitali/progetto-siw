package it.uniroma3.progettosiw.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.progettosiw.model.Autore;
import it.uniroma3.progettosiw.service.AutoreService;

@Controller
public class AutoreController {


	@Autowired
	private AutoreService autoreService;
	
	//Restituisce la Form dell'Autore
	@GetMapping ("/autore")
	public String showForm(Autore autore){
		return "formAutore";
	}
	
	//Verifica la correttezza dei dati inseriti
	@PostMapping ("/autore")
	public String checkAutoreInfo (@Valid @ModelAttribute Autore autore, BindingResult bindingResult, 
			Model model){

		if (bindingResult.hasErrors()) {
			return "formAutore";                                                          
		}
		else {
			model.addAttribute(autore);
			autoreService.add(autore); 
		}
		return "datiAutore";               
	}
	
	//Restituisce gli Autori nel sistema
	@GetMapping("/autori")
	public String getAutori(Model model){
		model.addAttribute("autori",this.autoreService.findAll());
		return "listaAutori";
	}
	
	//Fornisce la pagina dei dati di un particolare Autore
	@RequestMapping("/autori/{id}")
	public String getAutore(@PathVariable Long id,Model model){
		model.addAttribute("autore",this.autoreService.findById(id));
		return "datiAutore";
	}
	
	//Cancella un autore dalla pagina di tutti gli Autori
	@RequestMapping(value="/autori/{id}",method=RequestMethod.DELETE)
	public String deleteAutore(@PathVariable Long id){
		this.autoreService.deleteById(id);
		return "redirect:/autori";
	}
	
	//Porta alla form per modificare i dati di un Autore già nel Sistema
	@GetMapping("autori/autore/edit")
	public String editOpera(@RequestParam("id") Long id, Model model){
		Autore autore = this.autoreService.findById(id);
		model.addAttribute("autore", autore);
		return "formAutore";
	}
}
