package it.uniroma3.progettosiw.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.progettosiw.model.Opera;
import it.uniroma3.progettosiw.service.OperaService;

@Controller
public class GalleriaController {
	
	@GetMapping("/galleria")
	public String galleria(){
		return "galleria";
	}
	
	@PostMapping("/galleria")
	public String datiGalleria(Model model){
		OperaService service = new OperaService();
		List<Opera> opere = (List<Opera>) service.findAll();
		model.addAttribute("opere", opere);
		return "galleria";
	}
}
