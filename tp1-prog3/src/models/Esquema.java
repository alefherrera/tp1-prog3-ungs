package models;

import java.util.ArrayList;

/**
 * Esta clase se encarga de generar el esquema que va a tener una oracion.
 * por ej: sustantivo, verbo, sustantivo, adjetivo.
 * @author aherrera
 */
public class Esquema {

	public Esquema() {
		estructura = new ArrayList<Class<? extends Palabra>>();
	}

	private ArrayList<Class<? extends Palabra>> estructura;

	public ArrayList<Class<? extends Palabra>> getEstructura() {
		return estructura;
	}

	public void AgregarTermino(Class<? extends Palabra> p) {
		estructura.add(p);
	}

}
