package hw3;

import edu.du.dudraw.DUDraw;
import edu.du.dudraw.Draw;

public class Main {
    public static void main(String[] args) {
        // Load in the map
        try {
            ConcreteTerrainMap tm = new ConcreteTerrainMap("src/map1.txt");
            
            // Make the display panel
            SimWindow window = new SimWindow(tm);
            
            // Starting locations for varying avatars
            GridPoint MstartingLoc = new GridPoint(5, 5);
            GridPoint PstartingLoc = new GridPoint(4, 14);
            GridPoint FlystartingLoc = new GridPoint(9, 3);
            GridPoint FlystartingLoc2 = new GridPoint(14, 9);
            // Create individual Avatar objects
            MattAvatar matty = new MattAvatar(tm, MstartingLoc); 
            PenguinAvatar pen = new PenguinAvatar(tm, PstartingLoc);
            FairyAvatar freyia = new FairyAvatar(tm, FlystartingLoc);
            EagleAvatar america = new EagleAvatar(tm, FlystartingLoc2);
            
            // add avatars to list to be drawn in SimWindow
            window.addAvatar(matty);
            window.addAvatar(pen);
            window.addAvatar(freyia);
            window.addAvatar(america);
            
            // Start the simulation
            window.runSimulation(); // inc avatar movement


        } catch (TerrainFileException e) {
            System.err.println("Failed to load terrain map: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        }
    }
}

