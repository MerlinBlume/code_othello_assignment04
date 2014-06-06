package othello.model;


public class Player {

	private String name;
	private String colour;
	
	/**
	 * Sets the name of the player when the Player is constructed.
	 * 
	 * @param name
	 * 
	 */
	
	public Player(String name){
		this.name = name;
	}

	/**
	 * Returns the name of the player.
	 * @return PLayer's Name.
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * Returns the colour of the player.
	 * 
	 * @return colour of player
	 */
	public String getColour() {
		return colour;
	}
	
	/**
	 * Sets the colour of the Player.
	 * 
	 * @param colour
	 */
	public void setColour(String colour){
			
			this.colour = colour;
	}
	
	
}
