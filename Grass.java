package hw3;

import edu.du.dudraw.Draw;
import java.awt.Color;

class Grass extends TerrainTile {
	// class for grass
	
	private int veg;
	
	// constructor method
	public Grass(GridPoint location) {
		super(location);
		
		//this.setVeg(75);
		veg = 100; // Grass starts as full vegetation
	}
	
	@Override
	public void setColor(Draw duDwin) {
		//int greenValue = 200; // can be modified based on diff levels of vegitation in terrain
		//duDwin.setPenColor(0, greenValue, 0); // Grass RBG pen color
		
		// veg is between 0-100, make vegcolour between 150-250
		int vegColor = 250-veg;
		duDwin.setPenColor(new Color(0, vegColor, 0));
	}

	@Override
	public int getVeg() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public int getBumpy() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWet() {
		// TODO Auto-generated method stub
		return 30;
	}
}