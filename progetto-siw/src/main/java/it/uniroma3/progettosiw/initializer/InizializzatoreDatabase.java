package it.uniroma3.progettosiw.initializer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.progettosiw.model.Autore;
import it.uniroma3.progettosiw.model.Opera;
import it.uniroma3.progettosiw.repository.AutoreRepository;
import it.uniroma3.progettosiw.repository.OperaRepository;

@Component
public class InizializzatoreDatabase  implements ApplicationRunner {
	
	@Autowired
	private OperaRepository operaRepository;
	@Autowired
	private AutoreRepository autoreRepository;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Autore autoreTest1 = new Autore("nomeAutore1", "cognomeAutore1", "nazionalita1", format.parse("01-01-2001"), format.parse("02-02-2002"));
		Autore autoreTest2 = new Autore("nomeAutore2", "cognomeAutore2", "nazionalita2", format.parse("03-03-2003"), format.parse("04-04-2004"));
		
		Opera operaTest1 = new Opera("titoloOpera1", 100, "tecnicaOpera1", 10, 20, autoreTest1);
		Opera operaTest2 = new Opera("titoloOpera2", 200, "tecnicaOpera2", 20, 40, autoreTest1);
		Opera operaTest3 = new Opera("titoloOpera3", 300, "tecnicaOpera3", 30, 60, autoreTest2);
		
		List<Opera> opereAutore1 = new ArrayList<Opera>();
		List<Opera> opereAutore2 = new ArrayList<Opera>();
		
		opereAutore1.add(operaTest1);
		opereAutore1.add(operaTest2);
		opereAutore2.add(operaTest3);
		
		autoreTest1.setOpereRealizzate(opereAutore1);
		autoreTest2.setOpereRealizzate(opereAutore2);
		
		this.autoreRepository.save(autoreTest1);
		this.autoreRepository.save(autoreTest2);
		this.operaRepository.save(operaTest1);
		this.operaRepository.save(operaTest2);
		this.operaRepository.save(operaTest3);

		
	}
}
