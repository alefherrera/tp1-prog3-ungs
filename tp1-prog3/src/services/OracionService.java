package services;

import java.util.ArrayList;
import java.util.List;

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

	public List<String> GenerarOraciones(Topico topico, Integer cantidad) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < cantidad; i++) {
			result.add(GenerarOracion(topico));
		}
		return result;
	}

	public String GenerarOracion(Topico topico) {
		RandomService rs = RandomService.getInstance();
		Esquema esquema = rs.randomEsquema();

		List<String> r = new ArrayList<String>();
		PalabraService pal = PalabraService.getInstance();

		Palabra filtro = null;
		//Numero num = null;
		Boolean cond[] = { false, false, false };
		for (Class<? extends Palabra> p : esquema.getEstructura()) {
			if (cond[0] && cond[1] && cond[2])
			{
				filtro = null;
				cond[0] = cond[1] = cond[2] = false;
			}
			Palabra pa = pal.traerPalabra(p, filtro, topico);
			if (pa.ID() == 0)
				filtro = pa;
			r.add(pa.toString());
			cond[pa.ID()] = true;
		}
		return String.join(" ", r) + ".";
	}

}
