package it.uniroma3.progettosiw.controller;

import java.util.List;

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
import it.uniroma3.progettosiw.model.Opera;
import it.uniroma3.progettosiw.service.AutoreService;
import it.uniroma3.progettosiw.service.OperaService;

@Controller
public class OperaController {

	@Autowired
	private OperaService operaService;
	@Autowired
	private AutoreService autoreService;

	//Restituisce la Form dell'Opera
	@GetMapping("/opera")
	public String showFormOpera(Opera opera, Model model){
		List<Autore> autori = (List<Autore>) this.autoreService.findAll();		//Riceve la lista degli Autori presenti nel 
		model.addAttribute("autori", autori);									//sistema per il menu dropdown
		return "formOpera";
	}

	//Verifica la correttezza dei dati inseriti
	@PostMapping("/opera")
	public String checkOperaInfo(@Valid @ModelAttribute Opera opera, BindingResult result, Model model){
		if(result.hasErrors()){
			List<Autore> autori = (List<Autore>) this.autoreService.findAll();
			model.addAttribute("autori", autori);
			return "formOpera";
		}
		else{
			model.addAttribute(opera);
			this.operaService.add(opera);
		}
		return "datiOpera";
	}
	
	//Restituisce le Opere nel sistema
	@GetMapping("/opere")
	public String getOpere(Model model){
		model.addAttribute("opere",this.operaService.findAll());
		return "listaOpere";
	}
	
	//Fornisce la pagina dei dati di una particolare Opera
	@RequestMapping("/opere/{id}")
	public String getOpera(@PathVariable Long id,Model model){
		model.addAttribute("opera",this.operaService.findById(id));
		return "datiOpera";
	}
	
	//Cancella un autore dalla pagina di tutti gli Autori
	@RequestMapping(value="/opere/{id}",method=RequestMethod.DELETE)
	public String deleteOpera(@PathVariable Long id){
		this.operaService.deleteById(id);
		return "redirect:/opere";
	}
	
	//Porta alla form per modificare i dati di un Autore già nel Sistema
	@GetMapping("opere/opera/edit")
	public String editOpera(@RequestParam("id") Long id, Model model){
		Opera opera = this.operaService.findById(id);
		model.addAttribute("opera", opera);
		List<Autore> autori = (List<Autore>) this.autoreService.findAll();
		model.addAttribute("autori", autori);
		return "formOpera";
	}
}
