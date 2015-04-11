package models;

import enums.Numero;
import enums.Persona;
import enums.Tiempo;

public class Verbo extends Palabra {
	private Tiempo tiempo;
	private Persona persona;
	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Verbo(String texto, Tiempo tiempo, Persona persona, Numero numero) {
		super(texto, numero);
		this.tiempo = tiempo;
		this.persona = persona;
	}

	public Verbo() {

	}
}
