package no.hvl.dat100.jplab11.oppgave1;

import no.hvl.dat100.jplab11.common.TODO;

public abstract class Innlegg {

	private String bruker;
	private int id;
	private int likes;
	private String dato;
	
	public Innlegg() {
	}
	
	public Innlegg(int id, String bruker, String dato) {
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
	}

	public Innlegg(int id, String bruker, String dato, int likes) {
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;
	}
	
	public String getBruker() {
		return bruker;
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getId() {
		return id;
	}

	public int getLikes() {
		return likes;
	}
	
	public void doLike () {
		likes++;
	}
	
	public boolean erLik(Innlegg innlegg) {
		if (innlegg == null)
			return false;
		if (this.id != innlegg.getId())
			return false;
		if (this.bruker != innlegg.getBruker())
			return false;
		if (this.dato != innlegg.getDato())
			return false;
		if (this.likes != innlegg.getLikes())
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return id + "\n" + bruker + "\n" + dato + "\n" + likes + "\n";		
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
