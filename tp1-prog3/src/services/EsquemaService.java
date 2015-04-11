package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Esquema;

//TODO Esto acepta un refactor para dejar los metodos repetidos en una clase padre si se quiere
//va, si quieren
public class EsquemaService {

	private static final String ESQUEMASFILE = "esquemas.xml";

	private List<Esquema> esquemas;

	private static EsquemaService instance;

	public static EsquemaService getInstance() {
		if (instance == null)
			instance = new EsquemaService();
		return instance;
	}

	private EsquemaService() {
		esquemas = new ArrayList<Esquema>();
		ensureFile(ESQUEMASFILE, esquemas);
		RecuperarTodo();
	}
	
	public List<Esquema> getEsquemas(){
		return esquemas;
	}
	
	public boolean agregarEsquema(Esquema esquema){
		if(esquemas.contains(esquema))
			return false;
		return esquemas.add(esquema);
	}
	
	public void PersistirTodo() {
		try {
			PersistenciaService.getInstance().put(esquemas, ESQUEMASFILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void RecuperarTodo() {
		try {
			esquemas = PersistenciaService.getInstance().get(ESQUEMASFILE);
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
