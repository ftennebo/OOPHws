package hw3;

class InvalidTerrainTypeException extends TerrainFileException {
	private static final long serialVersionUID = 1L; // Java fill in

	public InvalidTerrainTypeException(String message) {
        super(message);
    }
}
