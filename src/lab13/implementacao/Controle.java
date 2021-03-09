package lab13.implementacao;

import java.io.IOException;

import lab13.itens.*;

/*
 * Essa classe implementa o DESIGN PATTERN SINGLETON
 * A motivacao da utilizacao desse design patter e o fato de que deve haver apenas um controle para o jogo
 */

public class Controle {
	private static Controle controleInstance;
	private Robot robo;
	private Map mapa;

	private Controle() {

	}

	public static Controle getInstance() {
		if (controleInstance == null)
			controleInstance = new Controle();
		return controleInstance;
	}

	public void addRobot(Robot robo) {
		this.robo = robo;
	}

	public void addMap(Map mapa) {
		this.mapa = mapa;
	}

	public void w() throws IOException {
		if (robo.getPosX() == 0)
			throw new IOException("Posicao nao pertence ao mapa");
		if (!mapa.verificaPosicao(robo.getPosX() - 1, robo.getPosY()).toString().contentEquals("--"))
			throw new IOException("Posicao ja esta ocupada");
		Representable newEmpty = new Empty(robo.getPosX(), robo.getPosY());
		robo.sobe();
		mapa.addItem(robo);
		mapa.addItem(newEmpty);
	}

	public void s() throws IOException {
		if (robo.getPosX() == mapa.getDimensao() - 1) {
			throw new IOException("Posicao nao pertence ao mapa");
		} else if (!mapa.verificaPosicao(robo.getPosX() + 1, robo.getPosY()).toString().contentEquals("--")) {
			throw new IOException("Posicao ja esta ocupada");
		} else {
			Representable newEmpty = new Empty(robo.getPosX(), robo.getPosY());
			robo.desce();
			mapa.addItem(robo);
			mapa.addItem(newEmpty);
		}
	}

	public void a() throws IOException {
		if (robo.getPosY() == 0)
			throw new IOException("Posicao nao pertence ao mapa");
		if (!mapa.verificaPosicao(robo.getPosX(), robo.getPosY() - 1).toString().contentEquals("--"))
			throw new IOException("Posicao ja esta ocupada");
		Representable newEmpty = new Empty(robo.getPosX(), robo.getPosY());
		robo.esquerda();
		mapa.addItem(robo);
		mapa.addItem(newEmpty);
	}

	public void d() throws IOException {
		if (robo.getPosY() == mapa.getDimensao() - 1)
			throw new IOException("Posicao nao pertence ao mapa");
		if (!mapa.verificaPosicao(robo.getPosX(), robo.getPosY() + 1).toString().contentEquals("--"))
			throw new IOException("Posicao ja esta ocupada");
		Representable newEmpty = new Empty(robo.getPosX(), robo.getPosY());
		robo.direita();
		mapa.addItem(robo);
		mapa.addItem(newEmpty);

	}

	public void g() {
		int posicoesAdjacentes[][] = { { robo.getPosX() - 1, robo.getPosY() }, { robo.getPosX(), robo.getPosY() - 1 },
				{ robo.getPosX(), robo.getPosY() + 1 }, { robo.getPosX() + 1, robo.getPosY() } };
		boolean itemFound = false;
		for (int[] posicao : posicoesAdjacentes) {
			try {
				Representable tentativa = mapa.verificaPosicao(posicao[0], posicao[1]);
				if (tentativa.toString().equals("$$")) {
					robo.usaItem((Usable) tentativa);
					itemFound = true;
				} else if (tentativa.toString().equals("JB")) {
					robo.usaItem((Usable) tentativa);
					robo.coletaItem((Storable) tentativa);
					itemFound = true;
				} else if (tentativa.toString().equals("JG")) {
					robo.coletaItem((Storable) tentativa);
					itemFound = true;
				} else if (tentativa.toString().equals("JR")) {
					robo.coletaItem((Storable) tentativa);
					itemFound = true;
				}
				if (itemFound == true) {
					if (!tentativa.toString().equals("$$")) {
						mapa.removeItem(tentativa);
						//break; // Esse break, quando utilizado, faz com que o robo so pegue no maximo
								 //	um item a cada vez que o usuario aperte a tecla "g".
								 // No caso, estou optando por deixar desativado, para que seja
								 // possivel pegar multiplos itens de uma so vez
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			}
		}
	}

}
