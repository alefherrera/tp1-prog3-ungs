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
	
	@Override
	public String toString() {
		String aux = texto.substring(texto.length() -1, texto.length());
		if(aux.equals("s"))
			aux = texto.substring(texto.length() -2, texto.length());
		
		switch(aux){
		case "a":
			return "la " + texto;
		case "as":
			return "las " + texto;
		case "o":
			return "el " + texto;
		case "os":
			return "los " + texto;	
		default:
			return texto;
		}
	}
	
}
