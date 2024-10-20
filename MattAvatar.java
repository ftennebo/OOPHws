package hw3;

import java.util.ArrayList;
import java.util.Random;
import edu.du.dudraw.Draw; 

public class MattAvatar extends Avatar{

	protected MattAvatar(TerrainMap tm, GridPoint point) {
		super(tm, point);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Draw duDwin) {
		
		int width = 35;
		int height = 35;
		// Testing: System.out.println("Drawing Matty");
		//picture(double x, double y, String filename)}
		//duDwin.picture(width, height, "src/hw3/MattAvatar.png");
		duDwin.picture((point.getX()* width) + (width/2), ((point.getY() * height) + (height/2)), "src/hw3/MattAvatar.png", width, height);

	}

	@Override
	public void move() {
		
		// generating random movement
		// generate a random integer in the range of 0-100. Only move if the integer is a multiple of 6
		boolean mattMoves; // create boolean
		Random rand = new Random(); // create an instance of random class
		int randInt = rand.nextInt(100);
		if (randInt % 6 == 0) {
			mattMoves = true;
		} else {
			mattMoves = false;
		}
		
		
		if (mattMoves) { // move while mattMoves is true: 
			// get neighbor points to see options, matt can only walk on the road
			ArrayList<GridPoint> options = this.point.getNeighbors(1);
			
			System.out.println("Calling move function");
			
			ArrayList<GridPoint> validOptions = new ArrayList<>(); // Matt can only walk on the road
			// Filter out neighbors that are not roads
	        for (GridPoint option : options) {
	            TerrainTile tile = this.map.getTile(option);
	            System.out.println(tile); 
	            // if the tile type is Road, add it to the list of valid options
	            if (tile instanceof Road) {  
	                validOptions.add(option);
	            }
	        }
	        // choose a random option to move to, of the valid options
	        if (!validOptions.isEmpty()) {
	            GridPoint newPoint = validOptions.get(new Random().nextInt(validOptions.size()));
	            this.point = newPoint;  // Update avatar's position
	            System.out.println("MattAvatar moved to: " + newPoint);
	        } else {
	            System.out.println("No valid roads to move to.");
	        }
	        
			
		
		} 
		
	}

}
