package it.uniroma3.it.modello;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Opera {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String titolo;
	private int anno;
	private String tecnica;
	private int lunghezza;
	private int larghezza;
	private Autore autore; 

	public Opera (String titolo, int anno, String tecnica, int lunghezza, int larghezza, Autore autore){
		this.titolo = titolo;
		this.anno = anno;
		this.tecnica = tecnica;
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.autore = autore;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public int getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}

	public int getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}


}
