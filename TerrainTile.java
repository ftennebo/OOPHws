package hw3;

//import java.util.Random;

import edu.du.dudraw.Draw;

// This is an abstract class
public abstract class TerrainTile implements Drawable {
	
	// Every tile has a location
	private GridPoint location;
	
	protected TerrainTile (GridPoint location) {
		this.setLocation(location);
	}

	// Draws the tile on the given Window
	public void draw(Draw duDwin) {
		// TODO: Get the derived class to set whatever color it wants by calling 
		// the abstract method.
		// TODO: draw the tile in a standard way
		
		setColor(duDwin);
		
		// Get tileWidth and tileHeight separately
	    int tileWidth = SimWindow.windowWidth / TerrainMap.gridWidth;    // Calculate width of the tile
	    int tileHeight = SimWindow.windowHeight / TerrainMap.gridHeight; // Calculate height of the tile

		
	    // Draw the tile at the correct position using getLocation() for x and y coordinates
	    int x = getLocation().getX() * tileWidth;  // Calculate x position
	    int y = getLocation().getY() * tileHeight; // Calculate y position

	    // Draw the rectangle for the tile with the appropriate width and height - assuming square pixels
	    duDwin.filledRectangle(x + tileWidth / 2, y + tileHeight / 2, tileWidth / 2, tileHeight / 2); 
	}
	
	
	
	// Part of the draw template for concrete tiles to set the color
	public abstract void setColor(Draw duDwin);

	public GridPoint getLocation() {
		return location;
	}

	public void setLocation(GridPoint location) {
		this.location = location;
	}
	
	
	
    
 // Allows tiles to provide different information
 	//   on the vegetation, smoothness, and water content to tile 
 	public abstract int getVeg();
 	public abstract int getBumpy();
 	public abstract int getWet();
 	
 	// Allows an avatar to eat at this tile
 	public void eat(int amt) {
 		// Do nothing by default
 	}
}
 
 	
