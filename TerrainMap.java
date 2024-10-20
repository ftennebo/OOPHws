package hw3;

// imports

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import edu.du.dudraw.Draw;


// The TerrainMap represents a 2D grid of Tiles

public abstract class TerrainMap implements Drawable {

	private final Map<GridPoint, TerrainTile> theTiles = new HashMap<>(); // create theTiles map
	
	// public static constants set in the constructor.
	public static int gridWidth;
	public static int gridHeight;

	// Constructor to read from file
	public TerrainMap(String filename) throws TerrainFileException{
		// TODO: Read the map specified by `filename` and add
		// TerrainTile objects (based on the terrain type specified by the map)
		// to theTiles.œ
		// TODO: make sure you set gridWidth and gridHeight static data members when you 
				// read the map.
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String firstLine = br.readLine(); // read map
			String[] dimensions = firstLine.split(" "); // get rid of whitespace
		
			
			// error check 
			if (dimensions.length != 2) {
				throw new MalformedTerrainFileException("File does not contain grid dimensions.");
			}
			
			// get gridWidth and Height
			gridWidth = Integer.parseInt(dimensions[0]);
            gridHeight = Integer.parseInt(dimensions[1]);
            
            // Testing: 
            // System.out.println(gridWidth);
            // System.out.println(gridHeight);
			
            for (int y = gridHeight - 1; y > -1 ; y--) { // Start at the top, and decrease y
            	// off by one errors - fixed by this ? 
            	String line = br.readLine();
            	
            	if (line == null) {
            		// Error Checking 
            		throw new MalformedTerrainFileException("File has fewer rows than specified.");
                }
            	
            	String[] terrainTypes = line.split(" "); // split every line by space to get individual char representing terrainType
            	
            	for (int x = 0; x < gridWidth; x++) { // loop through each x
            		
            		char terrainType = terrainTypes[x].charAt(0); // Get the char for the terrain type
            		
            		GridPoint point = new GridPoint(x, y); // Create new grid point for this position
                    
            		// Testing: System.out.println("POINT PUTTING ON GRAPH " + point);
                    
                    // Old Code: TerrainTile tile = createTerrainTile(terrainType, point); // Create the tile
                    // Replace Old Code with new factory
            		
            		TerrainTile tile = TerrainTileFactory.newTerrainTile(terrainType, point);                    
            		
            		theTiles.put(point, tile); // Store the tile in the map
            	
            	}
            }
		}
            catch (IOException e) {
                throw new TerrainFileException("Error reading terrain file.");
            }
		}
		
	@Override
    public void draw(Draw duDwin) {
	
		 for (Map.Entry<GridPoint, TerrainTile> entry : theTiles.entrySet()) {
			 entry.getValue().draw(duDwin);
		 } 
	}
	
	// Methods to get access to the individual tiles - veg, wet, bumpy, and eat methods
	 
	public int getVeg(GridPoint position) {
		 // TODO getVeg() -> not static, belongs to an instance of the class
		 	// so get the specific instance of TerrainTile and then call getVeg
		TerrainTile theTile = theTiles.get(position); // Get tile from map, using given key
		// Testing: System.out.println("The veg value is: " + theTile.getVeg());
		return theTile.getVeg(); // return the vegetation value of given tile

	}
	 
	public int getWet(GridPoint position) {
		var theTile = theTiles.get(position); // var instead of TerrainTile - more compact
		return theTile.getWet();
	}
	public int getBumpy(GridPoint position) {
		var theTile = theTiles.get(position); 
		return theTile.getBumpy();
	}

	public void eat(GridPoint position, int amt) {

	}
	
	public TerrainTile getTile(GridPoint point) {
	    return theTiles.get(point);  // Get the tile at the specified point
	}
}

