package models;

import enums.Genero;
import enums.Numero;
import enums.Persona;

public class Adjetivo extends Palabra {

	private Genero genero;

	public Adjetivo(String texto, Genero genero, Numero numero) {
		super(texto, numero);
		this.genero = genero;
	}

	public Adjetivo() {

	}
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	@Override
	public int ID() {
		return 1;
	}

}
