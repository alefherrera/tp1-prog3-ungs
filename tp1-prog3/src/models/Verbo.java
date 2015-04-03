package models;

import enums.Tiempo;

public class Verbo extends Palabra {
	private Tiempo tiempo;

	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	public Verbo(String texto, Tiempo tiempo) {
		super(texto);
		this.tiempo = tiempo;
	}

	public Verbo() {

	}
}
