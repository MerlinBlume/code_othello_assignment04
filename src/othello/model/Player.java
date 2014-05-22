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

	public void setColour(String colour) {
		if(colour.equalsIgnoreCase("b") || colour.equalsIgnoreCase("w"))
			this.colour = colour;
		else
			System.out.print("Please enter a valid colour.");
	}

	
	
}
