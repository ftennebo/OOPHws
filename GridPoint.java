package hw3;

import java.util.ArrayList;
import java.util.Objects;

/*
 * Class to represent an x and y grid location.
 * 
 * TODO: Should have standard methods: equals, toString, hashCode, compareTo
 * 		complete the methods 
 */ 
public class GridPoint implements Comparable<GridPoint>{
	
	
	// Declare instance variables
	private int x; // x variable
	private int y; // y variable
	
	// Constructor - initialize variables
    public GridPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Getter Methods for x and y
    public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

    @Override
    public int compareTo(GridPoint that) { 
        if (this.y != that.y) { // test y values first
            return Integer.compare(this.y, that.y);
        }
        return Integer.compare(this.x, that.x); 
    }
	
	
	public String toString() {
		String returnString = "Coordinates:";
		
		// add x and y to returnString with format: Coordinates: (x, y)
		returnString += " (" + x + ",";
		returnString += " " + y + ")";
		
		return returnString;
	}
	
	@Override
	public boolean equals(Object obj) {
		// Java/Eclipse generated equals method
		// compares equality of objects
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GridPoint other = (GridPoint) obj;
		return x == other.x && y == other.y;
	}
	
	@Override
	public int hashCode() {
		// Eclipse generated hashCode 
		return Objects.hash(x, y);
	}
	
	// Neighbor finding methods
	// provides a List of neighboring GridPoints
	public ArrayList<GridPoint> getNeighbors(int levels) {
		ArrayList<GridPoint> al = new ArrayList<GridPoint>(); // create list to hold tile options
	
		// starting position (x,y) is this.x and this.y
		
		// get the rows above (x,y)
		for (int i = -levels; i <= levels; i ++) {
			// start at x-levels... then x... then x+levels (max)
			for (int f = -levels; f <= levels; f++) {
				// skip the starting point
				if (i == 0 && f ==0) {
					continue; 
				}
				// create new variables for neighbouring x and y points
				int neighbX = this.x + i;
				int neighbY = this.y + f;
				
				// check that all the points are within the bounds of the grid
				if (neighbX <= TerrainMap.gridWidth && neighbY <= TerrainMap.gridHeight) {
					GridPoint point = new GridPoint(neighbX, neighbY); // make a new gridpoint
					al.add(point); // add the point to the list
				}
			}
		}
		return al; // return the list with all the points
	}
}
