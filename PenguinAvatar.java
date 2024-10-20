package hw3;

import java.util.ArrayList;
import java.util.Random;
import edu.du.dudraw.Draw; 

public class PenguinAvatar extends Avatar{

	protected PenguinAvatar(TerrainMap tm, GridPoint point) {
		super(tm, point);
	}
	
	public void draw(Draw duDwin) {
		
		int width = 35;
		int height = 35;
		duDwin.picture((point.getX()* width) + (width/2), ((point.getY() * height) + (height/2)), "src/hw3/PenguinAvatar.png", width, height);

	}

	@Override
	public void move() {
		
		// generating random movement - get a random integer in the range of 0-100. Only move if the integer is a multiple of 9
		boolean PMoves; 
		Random rand = new Random(); 
		int randInt = rand.nextInt(100);
		if (randInt % 9 == 0) {
			PMoves = true;
		} else {
			PMoves = false;
		}
		
		if (PMoves) { 
			// get neighbor points to see options, Penguin can only swim in water
			ArrayList<GridPoint> options = this.point.getNeighbors(8);
			ArrayList<GridPoint> validOptions = new ArrayList<>(); 
			
			// Filter out neighbors that are not water
	        for (GridPoint option : options) {
	            TerrainTile tile = this.map.getTile(option);
	            if (tile instanceof Water) {  
	                validOptions.add(option);
	            }
	        }
	        // choose a random point to move to, of the valid options
	        if (!validOptions.isEmpty()) {
	            GridPoint newPoint = validOptions.get(new Random().nextInt(validOptions.size()));
	            this.point = newPoint;  // Update avatar's position
	        } else {
	            System.out.println("No valid water to move to.");
	        }
		} 
	}
}
