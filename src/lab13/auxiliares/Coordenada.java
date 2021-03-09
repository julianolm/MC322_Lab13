package lab13.auxiliares;

public class Coordenada {
	private int x;
	private int y;
	
	public Coordenada(int posX, int posY) {
		x = posX;
		y = posY;
	}
	
	public void mudaCoordenada(int newX, int newY) {
		this.x = newX;
		this.y = newY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
