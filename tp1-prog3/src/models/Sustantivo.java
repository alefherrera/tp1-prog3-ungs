package models;

import enums.Genero;
import enums.Numero;
import enums.Topico;

public class Sustantivo extends Palabra {

	private Genero genero;
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	private Numero numero;
	private Topico topico;

	public Sustantivo(String texto, Genero genero, Numero numero, Topico topico) {
		super(texto);
		this.genero = genero;
		this.numero = numero;
		this.topico = topico;
	}

	public Sustantivo() {

	}

}
