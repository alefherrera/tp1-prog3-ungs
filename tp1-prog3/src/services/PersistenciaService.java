package services;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PersistenciaService {

	private static PersistenciaService instance;

	public static PersistenciaService getInstance() {
		if (instance == null)
			instance = new PersistenciaService();
		return instance;
	}

	private PersistenciaService() {

	}

	public <T> void put(T obj, String filename) throws FileNotFoundException {
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
				new FileOutputStream(filename)));
		encoder.writeObject(obj);
		encoder.close();
	}

	public <T> T get(String filename) throws FileNotFoundException {
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(
				new FileInputStream(filename)));
		T o = (T) decoder.readObject();
		decoder.close();
		return o;
	}

	public void save(String text, String fileName) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (out != null) {
			out.println(text);
			out.close();
		}
	}

}
