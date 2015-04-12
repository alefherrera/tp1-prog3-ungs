package services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import models.Esquema;
import models.Palabra;
import models.Sustantivo;
import enums.Numero;
import enums.Topico;

public class RandomService {
	private static RandomService instance;

	public static RandomService getInstance() {
		if (instance == null)
			instance = new RandomService();
		return instance;
	}

	private RandomService() {

	}

	public Esquema randomEsquema() {
		EsquemaService es = EsquemaService.getInstance();
		List<Esquema> esq = es.getEsquemas();
		return esq.get(new Random().nextInt(esq.size()));
	}

	public Palabra randomPalabra(List<? extends Palabra> arr, Numero numero, Topico topico) {
		boolean sus = false;
		List<Sustantivo> auxSust = null;
		List<? extends Palabra> aux = arr;
		
		if(arr.get(0).getClass().equals(Sustantivo.class))
		{
			sus = true;
			auxSust = (List<Sustantivo>) arr;
			if (numero != null){
				auxSust = auxSust.stream().filter(x-> x.getNumero() == numero && x.getTopico() == topico).collect(Collectors.toList());;
			}
			else{
				auxSust = auxSust.stream().filter(x-> x.getTopico() == topico).collect(Collectors.toList());;
			}
		} 
		else if (numero != null){
			
			 aux = arr.stream().filter(x-> x.getNumero() == numero).collect(Collectors.toList());;
			
		}
		return sus ? auxSust.get(new Random().nextInt(auxSust.size())) : aux.get(new Random().nextInt(aux.size()));
	}

}
