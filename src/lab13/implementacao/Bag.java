package lab13.implementacao;

import lab13.auxiliares.Impressora;
import lab13.itens.*;

public class Bag {
	private Storable[] bag;
	private int bagSize;
	private int valorTotal;
	
	public Bag() {
		bag = new Storable[99]; //maximo de 99 itens a guardar na mochila
		bagSize = 0;
		valorTotal = 0;
	}
	
	public void addItem(Storable item) {
		try {
		bag[bagSize++] = item;
		valorTotal += item.getPontuacao();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("Capacidade maxima da mochila atingida\n");
		}
	}
	
	public void imprime() {
		String mensagem = String.format("Bag total items: %d | Bag total value: %d\n", bagSize, valorTotal);
		Impressora.imprime(mensagem);
	}
}
