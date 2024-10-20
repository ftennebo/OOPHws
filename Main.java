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
            
            // Starting location 
            GridPoint startingLoc = new GridPoint(5, 5);
            
            String[] avatarNames = { "MattAvatar", "PenguinAvatar", "FairyAvatar", "EagleAvatar" };
            
            // Create individual Avatar objects
            for (String name : avatarNames) {
            	Avatar avatar = AvatarFactory.newAvatar(name, tm, startingLoc);
            	window.addAvatar(avatar); // add avatars to list
            }
            
            
            // Start the simulation
            window.runSimulation(); // inc avatar movement


        } catch (TerrainFileException e) {
            System.err.println("Failed to load terrain map: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        }
    }
}

