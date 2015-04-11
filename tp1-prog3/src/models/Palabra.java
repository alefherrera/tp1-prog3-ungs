package models;

import enums.Numero;

public abstract class Palabra {

	protected String texto;
	protected Numero numero;

	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palabra other = (Palabra) obj;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Palabra(String texto, Numero numero) {
		super();
		this.texto = texto;
		this.numero = numero;
	}

	public Palabra() {

	}

}
