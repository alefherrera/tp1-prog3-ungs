package models;

public abstract class Palabra {

	protected String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Palabra(String texto) {
		super();
		this.texto = texto;
	}

	public Palabra() {

	}

}
