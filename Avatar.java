package hw3;

public abstract class Avatar implements Drawable {
	
	// Avatars need access to TerrainMap - so they can see where to move
	protected final TerrainMap map;
    protected GridPoint point;
	
	protected Avatar (TerrainMap tm, GridPoint point) {
		// initialize 
		this.map = tm;
        this.point = point;		
	}
	
	// general abstract move method 
		// declaring move() as a method, but no implementation
		// abstract - like a template (every SubClass of Avatar must have a move() method)
	public abstract void move(); 
		
}

