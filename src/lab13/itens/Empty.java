package lab13.itens;

import lab13.auxiliares.Coordenada;

public class Empty implements Representable {
	private Coordenada pos;
	private String representacao = "--";
	
	public Empty(int x, int y){
		pos = new Coordenada(x, y);
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
