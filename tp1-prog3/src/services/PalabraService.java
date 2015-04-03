package services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import models.Adjetivo;
import models.Sustantivo;
import models.Verbo;

public class PalabraService {

	private final String SUSTANTIVOSFILE = "sustantivos.xml";
	private final String VERBOSFILE = "verbos.xml";
	private final String ADJETIVOSFILE = "adjetivos.xml";

	private List<Sustantivo> sustantivos;
	private List<Verbo> verbos;
	private List<Adjetivo> adjetivos;

	private static PalabraService instance;

	public static PalabraService getInstance() {
		if (instance == null)
			instance = new PalabraService();
		return instance;
	}

	private PalabraService() {
		sustantivos = new ArrayList<Sustantivo>();
		verbos = new ArrayList<Verbo>();
		adjetivos = new ArrayList<Adjetivo>();
		RecuperarTodo();
	}

	public void agregarSustantivo(Sustantivo sustantivo) {
		sustantivos.add(sustantivo);
	}

	public void agregarVerbo(Verbo verbo) {
		verbos.add(verbo);
	}

	public void agregarAdjetivo(Adjetivo adjetivo) {
		adjetivos.add(adjetivo);
	}

	public void PersistirTodo() {
		try {
			PersistenciaService.getInstance().put(sustantivos, SUSTANTIVOSFILE);
			PersistenciaService.getInstance().put(verbos, VERBOSFILE);
			PersistenciaService.getInstance().put(adjetivos, ADJETIVOSFILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void RecuperarTodo() {
		try {
			sustantivos = PersistenciaService.getInstance().get(SUSTANTIVOSFILE);
			verbos = PersistenciaService.getInstance().get(VERBOSFILE);
			adjetivos = PersistenciaService.getInstance().get(ADJETIVOSFILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
