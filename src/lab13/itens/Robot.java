package lab13.itens;

import lab13.auxiliares.Coordenada;
import lab13.auxiliares.Impressora;
import lab13.implementacao.Bag;


/*
 * Essa classe implementa o DESIGN PATTERN SINGLETON
 * A motivacao da utilizacao desse design patter e o fato de que o jogo jamais pode haver mais
 * de um robo e este, quando existir, deve ser sempre o mesmo.
 */

public class Robot implements Representable {
	private Coordenada pos;
	private Bag bag;
	private int energyPoints;
	private String representacao = "ME";
	private static Robot robotInstance;
	
	
	private Robot(int x, int y) {
		pos = new Coordenada(x, y);
		bag = new Bag();
		energyPoints = 5;
	}
	
	public static Robot getInstance(int x, int y) {
		if (robotInstance == null)
			robotInstance = new Robot(x, y);
		return robotInstance;
	}

	public void sobe() {
		reposicionaRobo(getPosX()-1, getPosY());
	}
	
	public void desce() {
		reposicionaRobo(getPosX()+1, getPosY());
	}
	
	public void esquerda() {
		reposicionaRobo(getPosX(), getPosY()-1);
	}
	
	public void direita() {
		reposicionaRobo(getPosX(), getPosY()+1);
	}
	
	public void reposicionaRobo(int x, int y) {
		pos.mudaCoordenada(x, y);
		this.energyPoints -= 1;
	}
	
	public boolean isAlive() {
		if (energyPoints >= 0)
			return true;
		else
			return false;
	}

//	public void reposicionaRoboY(int n) {
//		pos.mudaCoordenadaY(n);
//	}

	public void coletaItem(Storable item) {
		bag.addItem(item);
	}
	
	public void usaItem(Usable item) {
		this.energyPoints += item.getEnergyPoints();
	}

	public void imprimeSacola() {
		bag.imprime();
		String mensagem = String.format("Energy Points: %d\n", energyPoints);
		Impressora.imprime(mensagem);
	}

	@Override
	public int getPosX() {
		return pos.getX();
	}

	@Override
	public int getPosY() {
		return pos.getY();
	}

	@Override
	public String toString() {
		return representacao;
	}
}
