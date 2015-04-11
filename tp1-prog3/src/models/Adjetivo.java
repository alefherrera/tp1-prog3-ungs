package models;

import enums.Genero;
import enums.Numero;
import enums.Persona;

public class Adjetivo extends Palabra {

	private Persona persona;
	private Genero genero;

	public Adjetivo(String texto, Persona persona, Genero genero, Numero numero) {
		super(texto, numero);
		this.persona = persona;
		this.numero = numero;
	}

	public Adjetivo() {

	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
