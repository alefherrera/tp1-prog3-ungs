package services;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import models.Adjetivo;
import models.Palabra;
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
		
		ensureFile(ADJETIVOSFILE, adjetivos);
		ensureFile(SUSTANTIVOSFILE, sustantivos);
		ensureFile(VERBOSFILE, verbos);
		
		RecuperarTodo();
	}

	public boolean agregarSustantivo(Sustantivo sustantivo) {
		if (sustantivos.contains(sustantivo)) return false;
		return sustantivos.add(sustantivo);
	}

	public boolean agregarVerbo(Verbo verbo) {
		if (verbos.contains(verbo)) return false;
		return verbos.add(verbo);
	}

	public boolean agregarAdjetivo(Adjetivo adjetivo) {
		if (adjetivos.contains(adjetivo)) return false;
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
	
	public String traerPalabra(Class<? extends Palabra> c){
		RandomService rs = RandomService.getInstance();
		
		if(c.equals(Adjetivo.class)){
			return rs.randomPalabra(adjetivos);
		}
		else if(c.equals(Verbo.class)){
			return rs.randomPalabra(sustantivos);
		}
		else if(c.equals(Sustantivo.class)){
			return rs.randomPalabra(sustantivos);
		}
		return "";
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
