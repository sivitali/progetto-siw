package it.uniroma3.progettosiw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.progettosiw.model.Opera;
import it.uniroma3.progettosiw.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	private OperaService operaService;
	
	@GetMapping("/opera")
	public String showFormOpera(Opera opera){
		return "formOpera";
	}
	
	@PostMapping("/opera")
	public String checkOperaInfo(@Valid @ModelAttribute Opera opera, BindingResult result, Model model){
		if(result.hasErrors())
			return "formOpera";
		else{
			model.addAttribute(opera);
			this.operaService.add(opera);
		}
		return "datiOpera";
	}

}
