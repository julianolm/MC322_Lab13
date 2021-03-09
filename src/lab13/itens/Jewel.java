package lab13.itens;

import lab13.auxiliares.Coordenada;

public abstract class Jewel implements Representable, Storable {
	private Coordenada pos;
	private int pontuacao;
	private String representacao;

	public Jewel(int x, int y, String representacao, int pontuacao) {
		pos = new Coordenada(x, y);
		this.representacao = representacao;
		this.pontuacao = pontuacao;
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
	public int getPontuacao() {
		return pontuacao;
	}

	@Override
	public String toString() {
		return representacao;
	}

}
