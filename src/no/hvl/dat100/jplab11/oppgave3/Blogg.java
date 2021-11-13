package no.hvl.dat100.jplab11.oppgave3;

import java.util.Arrays;
import java.util.LinkedList;

import no.hvl.dat100.jplab11.oppgave1.Innlegg;

public class Blogg {

	private Innlegg[] samling;
	private int antall;

	public Blogg() {
		samling = new Innlegg[20];
	}

	public Blogg(int lengde) {
		samling = new Innlegg[lengde];
	}

	public int getAntall() {
		return antall;
	}

	public Innlegg[] getSamling() {
		return samling;
	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < antall; i++) {
			if (samling[i].equals(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass() {
		return antall < samling.length;
	}

	public boolean leggTil(Innlegg innlegg) {
		if (!ledigPlass())
			return false;
		samling[antall++] = innlegg;
		return true;
	}

	public String toString() {
		String resultat = antall + "\n";
		for (int i = 0; i < antall; i++)
			resultat += samling[i].toString();

		return resultat;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		samling = Arrays.copyOf(samling, samling.length * 2);
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!ledigPlass())
			utvid();
		samling[antall++] = innlegg;
		return true;
	}

	public boolean slett(Innlegg innlegg) {
		int i = finnInnlegg(innlegg);
		if (i == -1)
			return false;

		antall--;
		for (;i < antall; i++)
			samling[i] = samling[i + 1];

		return true;
	}

	public int[] search(String keyword) {
		LinkedList<Integer> resultat = new LinkedList<Integer>(); 
		for (int i = 0; i < antall; i++){
			if (samling[i].toString().contains(keyword))
				resultat.add(i);
		}

		int[] indices = new int[resultat.size()];
		for (int i = 0; i < indices.length; i++)
			indices[i] = resultat.poll();

		return indices;
	}
}