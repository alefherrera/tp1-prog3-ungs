package services;

import models.Esquema;
import enums.Topico;

public class OracionService {

	private static OracionService instance;

	public static OracionService getInstance() {
		if (instance == null)
			instance = new OracionService();
		return instance;
	}

	private OracionService() {

	}

	public String GenerarOracion(Esquema esquema, Topico tema) {
		String result = new String();
		return result;
	}

}
