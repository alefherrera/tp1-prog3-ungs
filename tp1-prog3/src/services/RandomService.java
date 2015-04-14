package services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import models.Adjetivo;
import models.Esquema;
import models.Palabra;
import models.Sustantivo;
import models.Verbo;
import enums.Genero;
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

	/*
	 * public Palabra randomPalabra(List<? extends Palabra> arr, Numero numero,
	 * Topico topico) { boolean sus = false;
	 * 
	 * List<? extends Palabra> aux = arr;
	 * 
	 * if(arr.get(0).getClass().equals(Sustantivo.class)) { sus = true; auxSust
	 * = (List<Sustantivo>) arr; if (numero != null){ auxSust =
	 * auxSust.stream().filter(x-> x.getNumero() == numero && x.getTopico() ==
	 * topico).collect(Collectors.toList());; } else{ auxSust =
	 * auxSust.stream().filter(x-> x.getTopico() ==
	 * topico).collect(Collectors.toList());; } } else if (numero != null){
	 * 
	 * aux = arr.stream().filter(x-> x.getNumero() ==
	 * numero).collect(Collectors.toList());;
	 * 
	 * } return sus ? auxSust.get(new Random().nextInt(auxSust.size())) :
	 * aux.get(new Random().nextInt(aux.size())); }
	 */

	public Sustantivo randomSustantivo(List<Sustantivo> arr, Topico t) {
		List<Sustantivo> aux = arr;

		aux = aux.stream().filter(x -> x.getTopico() == t)
				.collect(Collectors.toList());

		return random(aux);
	}

	public Palabra randomAdjetivo(List<Adjetivo> arr, Sustantivo p) {
		List<Adjetivo> aux = arr;
		aux = aux
				.stream()
				.filter(x -> x.getNumero() == p.getNumero())
						//&& x.getGenero() == p.getGenero())
				.collect(Collectors.toList());
		return random(aux);
	}

	public Palabra randomVerbo(List<Verbo> arr, Palabra p) {
		List<Verbo> aux = arr;
		aux = aux.stream().filter(x -> x.getNumero() == p.getNumero())
				.collect(Collectors.toList());
		return random(aux);
	}

	public Palabra randomPalabra(List<? extends Palabra> l, Palabra p) {
		List<? extends Palabra> aux = l;
		if (p != null) {
			aux = l.stream().filter(x -> x.getNumero() == p.getNumero())
					.collect(Collectors.toList());
		}
		return random(aux);
	}

	private <T> T random(List<T> arr) {
		return arr.get(new Random().nextInt(arr.size()));
	}

}
