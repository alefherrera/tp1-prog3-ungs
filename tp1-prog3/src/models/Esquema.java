package models;

import java.util.ArrayList;
import java.util.List;

//esta clase se encarga de generar el esquema que va a tener una oracion.
//por ej: sustantivo, verbo, sustantivo, adjetivo.
public class Esquema {

	public Esquema() {
		estructura = new ArrayList<Palabra>();
	}

	private List<Palabra> estructura;

	public List<Palabra> get_estructura() {
		return estructura;
	}

	public void AgregarTermino(Palabra p) {
		estructura.add(p);
	}

}
