package hw3;

public class AvatarFactory {
	
	public static Avatar newAvatar (String avaName, TerrainMap tm, GridPoint point) throws InvalidTerrainTypeException{
		
		// TODO - add all the other avatars
		
		
		// Check the avatar name and return the correct type of Avatar
        
		// Human: 
		if (avaName.equals("MattAvatar")) {
			// create new HumanAvatar - pass in parameters 
            return new MattAvatar(tm, point);
        } // Fairy
		else if (avaName.equals("FairyAvatar")) {
			// create new HumanAvatar - pass in parameters 
            return new FairyAvatar(tm, point);
		}// Penguin
		else if (avaName.equals("PenguinAvatar")) {
			// create new HumanAvatar - pass in parameters 
            return new PenguinAvatar(tm, point);
		}// Eagle
		else if (avaName.equals("EagleAvatar")) {
			return new EagleAvatar(tm, point);
		}
		
		
		// Error checking: 
			// thrown if avaName string does not match the expected class names.
		else {
		throw new InvalidTerrainTypeException("Invalid Avatar type: " + avaName);
		}
	}

}
