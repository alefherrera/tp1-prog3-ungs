package models;

import enums.Genero;
import enums.Numero;
import enums.Topico;

public class Sustantivo extends Palabra {

	private Topico topico;
	private Genero genero;
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	public Sustantivo(String texto, Genero genero, Numero numero, Topico topico) {
		super(texto, numero);
		this.genero = genero;
		this.topico = topico;
	}

	public Sustantivo() {

	}
}
