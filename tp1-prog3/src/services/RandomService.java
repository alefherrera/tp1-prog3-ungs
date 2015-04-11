package services;

import java.util.List;
import java.util.Random;

import models.Esquema;
import models.Palabra;

public class RandomService {
	private static RandomService instance;
	
	public static RandomService getInstance(){
		if(instance == null)
			instance = new RandomService(); 
		return instance;
	}
	
	private RandomService(){
	
	}
	
	public Esquema randomEsquema(){
		EsquemaService es = EsquemaService.getInstance();
		List<Esquema> esq = es.getEsquemas();
		return esq.get(new Random().nextInt(esq.size()));
	}
	
	
	public String randomPalabra(List<? extends Palabra> arr ){
		return arr.get(new Random().nextInt(arr.size())).getTexto();
	}
	
}
