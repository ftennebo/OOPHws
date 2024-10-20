package hw3;

import java.awt.Color;
import java.util.ArrayList;
import edu.du.dudraw.Draw;

public class SimWindow {

	// Some static constants that everyone can use
	//   the represent the window size
	public final static int windowWidth = 1050;
	public final static int windowHeight = 700;

	private TerrainMap tm;
	private ArrayList<Avatar> theAvatars;
	private Draw duDwin;
	
	private boolean paused;

	public SimWindow(TerrainMap tm) {
		
		// Testing: System.out.println("Drawing the map");

		// Setup the DuDraw window
		duDwin = new Draw("COMP2381 Animal Simulation"); 
		duDwin.setCanvasSize(SimWindow.windowWidth, SimWindow.windowHeight);
		duDwin.enableDoubleBuffering(); // Too slow otherwise 

		// Set the scale of the window - set to match the pixels
		duDwin.setXscale(0, SimWindow.windowWidth);
		duDwin.setYscale(0, SimWindow.windowHeight);
		System.out.println(SimWindow.windowHeight);

		this.setTm(tm); // TerrainMap
		this.theAvatars = new ArrayList<Avatar>(); // Empty list of avatars
		this.paused = false;
	}

	public void update() { // Clear the entire window to white and draw the TerrainMap
		duDwin.clear(Color.white);  // Clear in white
		
		// Draw the board
		tm.draw(duDwin);
		
		// Draw the avatars from the list 
		for (Avatar avatar : theAvatars) {
		    avatar.draw(duDwin);
		}
		duDwin.show();  // used in double buffering
	}

	public void runSimulation() {
		// This is the main game loop
		
		update(); // Initial positing
		
		while(true) {
				if (!paused) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// Avatar movement here
				for (Avatar avatar : theAvatars) {
                        avatar.move();  
				}
				update();
			}
		}
	}

	public TerrainMap getTm() {
		return tm;
	}

	public void setTm(TerrainMap tm) {
		this.tm = tm;
	}
	public Draw getDraw() {
	    return duDwin;
	}
	
	// Add the avatars 1 by 1 in an Avatar-array list
	public void addAvatar(Avatar a) {
		theAvatars.add(a);
	}
}