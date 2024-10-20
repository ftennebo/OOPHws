package hw3;

import edu.du.dudraw.Draw;

public class FairyAvatar extends FlyingAvatar {

	protected FairyAvatar(TerrainMap tm, GridPoint point) {
		super(tm, point);

	}
	
	@Override
    public void draw(Draw duDwin) {
        int width = 35;  // Eagles might be larger
        int height = 35;
        // Specific image for Eagle
        duDwin.picture((point.getX() * width) + (width / 2), (point.getY() * height) + (height / 2), "src/hw3/fairy.png", width, height);
    }

}
