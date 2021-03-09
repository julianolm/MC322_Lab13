package lab13.itens;

import lab13.auxiliares.Coordenada;

public abstract class Obstacle implements Representable {
	private Coordenada pos;
	private String representacao;
	
	public Obstacle(/*String tipo, */int x, int y, String representacao) {
		pos = new Coordenada(x, y);
		this.representacao = representacao;
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
