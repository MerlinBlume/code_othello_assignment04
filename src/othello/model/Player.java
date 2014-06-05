package othello.model;


public class Player {

	private String name;
	private String colour;
	
	public Player(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getColour() {
		return colour;
	}

	/*
	 * Took this out and made it consistant with "Disc" as otherwise it is harder to compare.
	 *  Matt Jones.
	 *  public void setColour(String colour) {
	 *	if(colour.equalsIgnoreCase("b") || colour.equalsIgnoreCase("w"))
	 *		this.colour = colour;
	 *	else
	 *		System.out.print("Please enter a valid colour.");
	 * }
     */
	
	public void setColour(String colour){
			
			this.colour = colour;
	}
	
	
}
