package hw3;

// This is a concrete class that extends the Tile class

import java.awt.Color;
import java.util.Random;

import edu.du.dudraw.Draw;

class Mountain extends TerrainTile {
	
    private int veg;

    public Mountain(GridPoint location) {
        super(location);
        // OLD CODE MILESTONE: this.veg = new Random().nextInt(51); // Generate random vegetation between 0-50
        // Make random stands of trees in the mountains
 		Random r = new Random();
 		this.veg = r.nextInt(50);
    }
    
    //@Override 
    // TODO - fix this u need this method 
	//public void eat(int amt) {

	//}

    @Override
	public void setColor(Draw duDwin) {
		// darkGray is 90,90,90
		duDwin.setPenColor(new Color(100,50+veg,100));
	}
    
    // taken from starter code:
    @Override
	public int getVeg() {
		// TODO:If we make this negative then there is no food
		return 0;
	}

	@Override
	public int getBumpy() {
		// TODO:// Mountains are very bumpy
		return 0;
	}

	@Override
	public int getWet() {
		// // TODO:Mountains aren't wet
		return 0;
	}
    
}