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
	
	//Inizialliza il database con delle Entità
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Autore daVinci = new Autore("Leonardo", "Da Vinci", "Italia", format.parse("15-04-1452"), format.parse("02-05-1519"));
		Autore botticelli = new Autore("Sandro", "Botticelli", "Italia", format.parse("01-03-1445"), format.parse("17-05-1510"));
		
		Opera damaErmellino = new Opera("Dama con l'ermellino", 1490, "Olio su tavola", 55, 40, daVinci);
		Opera gioconda = new Opera("La Gioconda", 1506, "Olio su tavola", 77, 53, daVinci);
		Opera nascitaVenere = new Opera("Nascita di Venere", 1485, "Tempera su tela", 172, 278, botticelli);
		
		List<Opera> opereDaVinci = new ArrayList<Opera>();
		List<Opera> opereBotticelli = new ArrayList<Opera>();
		
		opereDaVinci.add(damaErmellino);
		opereDaVinci.add(gioconda);
		opereBotticelli.add(nascitaVenere);
		
		daVinci.setOpereRealizzate(opereDaVinci);
		botticelli.setOpereRealizzate(opereBotticelli);
		
		this.autoreRepository.save(daVinci);
		this.autoreRepository.save(botticelli);
		this.operaRepository.save(damaErmellino);
		this.operaRepository.save(gioconda);
		this.operaRepository.save(nascitaVenere);

		
	}
}
