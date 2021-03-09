package lab13.itens;

public class BlueJewel extends Jewel implements Usable {
	private int energyPoints;
	
	
	public BlueJewel(int x, int y) {
		super(x, y, "JB", 10);
		energyPoints = 5;
	}

	@Override
	public int getEnergyPoints() {
		return energyPoints;
	}

}
