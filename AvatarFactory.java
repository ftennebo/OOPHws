package hw3;

public class AvatarFactory {
	
	public static Avatar newAvatar (String avaName, TerrainMap tm, GridPoint point) throws InvalidTerrainTypeException{
		
		// TODO - add all the other avatars
		
		
		// Check the avatar name and return the correct type of Avatar
        
		// Human: 
		if (avaName.equals("MattAvatar")) {
			// create new HumanAvatar - pass in parameters 
            return new MattAvatar(tm, point);
        } 
		// LocNessMonster:
		
		// Duck:
		
		// Unicorn: 
		
		// Error checking: 
			// thrown if avaName string does not match the expected class names.
        throw new InvalidTerrainTypeException("Invalid Avatar type: " + avaName);
	
	}

}
