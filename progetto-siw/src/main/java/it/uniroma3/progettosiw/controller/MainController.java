package it.uniroma3.progettosiw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


// Controller per accedere alla pagina di login
@Controller
public class MainController {

	// Login form
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	// Login form con errori
	@RequestMapping("/login-error.html")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

}
