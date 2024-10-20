package hw3;

public class TerrainTileFactory {
	
	// creates TerrainTile objects based on input
	// utility class
	
	public static TerrainTile newTerrainTile(char tileType, GridPoint point) throws InvalidTerrainTypeException {
		// static class to return type of tile needed based on string representation from map
		
		switch (Character.toLowerCase(tileType)) { // make sure terrain type is in lower case
		
		// get the terrain type
        case 'g':
            return new Grass(point);
        case 'w':
            return new Water(point);
        case 'r':
            return new Road(point);
        case 'm':
            return new Mountain(point);
        
        default: // Error checking: 
        	System.out.println("Processing row: " + point + ", character: " + tileType);

            throw new InvalidTerrainTypeException("Invalid terrain type: " + tileType);
    }
		
		
	}

}
