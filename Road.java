package hw3;

import java.awt.Color;
import edu.du.dudraw.Draw;

public class Road extends TerrainTile {
	// Uses code from given Starter Code
	
	public Road(GridPoint location) {
		super(location);
	}
	
	@Override
	public void setColor(Draw duDwin) {
		// Draw roads as yellow
		duDwin.setPenColor(Color.yellow);
	}
	
	@Override
	public int getVeg() {
		// TODO:// Roads have very little vegetation 
		return 5;
	}

	@Override
	public int getBumpy() {
		// // TODO:Roads are smooth
		return 0;
	}

	@Override
	public int getWet() {
		// // TODO: Roads aren't wet
		return 0;
	}

}
