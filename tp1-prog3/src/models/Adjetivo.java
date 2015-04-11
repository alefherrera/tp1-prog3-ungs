package models;

import enums.Numero;
import enums.Persona;

public class Adjetivo extends Palabra {

	private Persona persona;

	public Adjetivo(String texto, Persona persona, Numero numero) {
		super(texto, numero);
		this.setPersona(persona);
	}

	public Adjetivo() {

	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
