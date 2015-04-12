package services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import models.Esquema;
import models.Palabra;
import enums.Numero;

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

	public Palabra randomPalabra(List<? extends Palabra> arr, Numero numero) {

		List<? extends Palabra> aux = arr;
		if (numero != null)
		{
			 aux = arr.stream().filter(x-> x.getNumero() == numero).collect(Collectors.toList());;
		}
		return aux.get(new Random().nextInt(aux.size()));
	}

}
