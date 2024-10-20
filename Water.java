package hw3;

import edu.du.dudraw.Draw;

public class Water extends TerrainTile {
	    
	public Water(GridPoint location) {
	        super(location);
	    }
	
	// water as blue 
    @Override
    public void setColor(Draw duDwin) {
        int blueValue = 200;
    	duDwin.setPenColor(0, 100, blueValue); // RGB Water
    }
    
    @Override
	public int getVeg() {
		// Water is vegetated
		return 50;
	}

	@Override
	public int getBumpy() {
		// Water is fairly smooth
		return 0;
	}

	@Override
	public int getWet() {
		// Water is very wet
		return 100;
	}
    
}