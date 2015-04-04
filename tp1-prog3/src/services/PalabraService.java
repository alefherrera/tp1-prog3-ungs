package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import models.Adjetivo;
import models.Sustantivo;
import models.Verbo;

public class PalabraService {

	private final String SUSTANTIVOSFILE = "sustantivos.xml";
	private final String VERBOSFILE = "verbos.xml";
	private final String ADJETIVOSFILE = "adjetivos.xml";

	private HashSet<Sustantivo> sustantivos;
	private HashSet<Verbo> verbos;
	private HashSet<Adjetivo> adjetivos;

	private static PalabraService instance;

	public static PalabraService getInstance() {
		if (instance == null)
			instance = new PalabraService();
		return instance;
	}

	private PalabraService() {
		sustantivos = new HashSet<Sustantivo>();
		verbos = new HashSet<Verbo>();
		adjetivos = new HashSet<Adjetivo>();
		
		ensureFile(ADJETIVOSFILE, adjetivos);
		ensureFile(SUSTANTIVOSFILE, sustantivos);
		ensureFile(VERBOSFILE, verbos);
		
		RecuperarTodo();
	}

	public boolean agregarSustantivo(Sustantivo sustantivo) {
		return sustantivos.add(sustantivo);
	}

	public boolean agregarVerbo(Verbo verbo) {
		return verbos.add(verbo);
	}

	public boolean agregarAdjetivo(Adjetivo adjetivo) {
		return adjetivos.add(adjetivo);
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

	private <T> void ensureFile(String fileName, T list) {
		File archivo = new File(fileName);
		if (!archivo.isFile()) {
			try {
				PersistenciaService.getInstance().put(list, fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
