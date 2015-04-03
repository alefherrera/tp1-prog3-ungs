package services;

import java.io.FileNotFoundException;

import models.Adjetivo;
import models.Sustantivo;
import models.Verbo;

public class PalabraService {

	private static PalabraService instance;

	public static PalabraService getInstance() {
		if (instance == null)
			instance = new PalabraService();
		return instance;
	}

	public void grabarSustantivo(Sustantivo sustantivo) {
		try {
			PersistenciaService.getInstance()
					.put(sustantivo, "sustantivos.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void grabarVerbo(Verbo verbo) {
		try {
			PersistenciaService.getInstance().put(verbo, "verbos.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void grabarAdjetivo(Adjetivo adjetivo) {
		try {
			PersistenciaService.getInstance().put(adjetivo, "adjetivos.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
