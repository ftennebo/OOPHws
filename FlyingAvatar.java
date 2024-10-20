package hw3;

import java.util.ArrayList;
import java.util.Random;
import edu.du.dudraw.Draw;

public abstract class FlyingAvatar extends Avatar{

	protected FlyingAvatar(TerrainMap tm, GridPoint point) {
		super(tm, point);
	}
	
	@Override
	public void move() { // Shared flying movements
		// generating random movement:
		// get a random integer in the range of 0-100. Only move if the integer is even
		boolean mattMoves; // create boolean
		Random rand = new Random(); // create an instance of random class
		int randInt = rand.nextInt(100);
		if (randInt % 2 == 0) {
			mattMoves = true;
		} else {
			mattMoves = false;
		}
		
		ArrayList<GridPoint> options = this.point.getNeighbors(10); // let the animals fly super far
        
		ArrayList<GridPoint> mountains = new ArrayList<GridPoint>(); // only let them fly over mountains

		for (GridPoint option : options) { // iterate through possible tiles
			TerrainTile tile = this.map.getTile(option); // get tile
			
			if (tile instanceof Mountain) {
				mountains.add(option);
			}
		}
		if (!mountains.isEmpty()) {
            this.point = mountains.get(new Random().nextInt(mountains.size()));
        }
	}
	
	// Abstract method for drawing the different flying avatars
    @Override
    public abstract void draw(Draw duDwin);

}
