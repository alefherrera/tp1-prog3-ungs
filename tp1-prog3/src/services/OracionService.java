package services;

import models.Esquema;
import models.Palabra;
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
		PalabraService pal  = PalabraService.getInstance();
		
		for (Class<? extends Palabra> p : esquema.getEstructura()) {
			result += pal.traerPalabra(p) + " " ;
		} 
		return result.substring(0,result.length() - 1) + ".";
	}

}
