package lab13.implementacao;

import java.util.ArrayList;

import lab13.itens.*;

public class Map {
	private int dimensaoMapa;
	private Representable mapa[][]; // array de Obstacles com todos obstaculos do mapa

	public Map(int dimensao) {
		dimensaoMapa = dimensao;
		mapa = new Representable[dimensaoMapa][dimensaoMapa];
		for (int i = 0; i < dimensaoMapa; i++) {
			for (int j = 0; j < dimensaoMapa; j++) {
				mapa[i][j] = new Empty(i, j);
			}
		}
	}

	public void addItem(Representable item) {
		mapa[item.getPosX()][item.getPosY()] = item;
	}

	public void removeItem(Representable item) {
		int x = item.getPosX();
		int y = item.getPosY();
		mapa[x][y] = new Empty(x, y);
	}

	public Representable verificaPosicao(int x, int y) {
		return mapa[x][y];
	}

	public void imprimeMapa() {
		System.out.println("\n\n\n");
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				System.out.print(mapa[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public int getDimensao() {
		return this.dimensaoMapa;
	}

}
