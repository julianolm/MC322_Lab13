package lab13.itens;

public class Tree extends Obstacle implements Usable {
	private int energyPoints;

	public Tree(int x, int y) {
		super(x, y, "$$");
		energyPoints = 3;
	}

	@Override
	public int getEnergyPoints() {
		return energyPoints;
	}
	
}
