package services;

import java.util.ArrayList;
import java.util.List;

import models.Adjetivo;
import models.Esquema;
import models.Palabra;
import models.Verbo;
import enums.Numero;
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
	
	public List<String> GenerarOraciones(Topico topico, Integer cantidad){
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < cantidad; i++) {
			result.add(GenerarOracion(topico));
		}
		return result;
	}
	
	public String GenerarOracion(Topico topico) {
		RandomService rs = RandomService.getInstance();
		Esquema esquema = rs.randomEsquema();
		
		String result = new String();
		PalabraService pal  = PalabraService.getInstance();
		
		Palabra palabra;
		Numero num = null;
		Boolean adj,sus,ver;
		adj = sus = ver = false;
		for (Class<? extends Palabra> p : esquema.getEstructura()) {
			if(adj && sus && ver)
				num = null;
			
			palabra = pal.traerPalabra(p,num,topico);
			num = palabra.getNumero();
			result += palabra.toString() + " ";
			
			if (palabra.getClass().equals(Adjetivo.class)) {
				adj = true;
			} else if (palabra.getClass().equals(Verbo.class)) {
				ver = true;
			} else
				sus = true;
		
		} 
		return result.substring(0,result.length() - 1) + ".";
	}

}
