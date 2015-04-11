package models;

import java.util.ArrayList;

/**
 * Esta clase se encarga de generar el esquema que va a tener una oracion. por
 * ej: sustantivo, verbo, sustantivo, adjetivo.
 * 
 * @author aherrera
 */
public class Esquema {

	private ArrayList<Class<? extends Palabra>> estructura;

	public Esquema() {
		estructura = new ArrayList<Class<? extends Palabra>>();
	}
	
	
	public void setEstructura(ArrayList<Class<? extends Palabra>> estructura) {
		this.estructura = estructura;
	}

	public ArrayList<Class<? extends Palabra>> getEstructura() {
		return estructura;
	}

	
	public void AgregarTermino(Class<? extends Palabra> p) {
		estructura.add(p);
	}

	public void borrarUltimo() {
		if (estructura.size() == 0) return;
		estructura.remove(estructura.size() - 1);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Class<? extends Palabra> class1 : estructura) {
			sb.append(class1.getSimpleName()).append(" ");
		}
		return sb.toString();
	}
	
}
