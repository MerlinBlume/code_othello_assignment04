package othello.model;

/**
 * Disc is a Comparable object used to represent 
 * game pieces the player can place onto a Board.
 * 
 *
 */


public class Disc implements Comparable<Disc> {
	
	private String colour; // the colour of the disc
	private String symbol; // the Symbol of the disc
	
	public Disc(String colour){
		this.colour = colour;
	}
	
	public void setBlack(){
		this.colour = "Black";
	}
	
	public void setWhite(){
		this.colour = "White";
	}
	
	public void switchColour(){
		if (this.colour.equalsIgnoreCase("Black"))
				this.colour = "Black";
		else
			this.colour = "White";
	}
	
	// again ... this is more generic
	@Override
	public String toString() {
		if (this.colour.equalsIgnoreCase("White"))
			this.symbol = "O";
		else
			this.symbol = "X";
		return symbol;
	}
	
	// than this
	//
	//	public String getSymbol(){
	//		if (this.colour.equalsIgnoreCase("White") || this.colour.equalsIgnoreCase("w"))
	//			this.symbol = "X";
	//		else
	//			this.symbol = "O";
	//		return symbol;
	//	}

	
	// Compares this object with the specified object for. Returns a negative integer, zero,
	// or a positive integer as this object is less than, equal to, or greater than the specified object. 
	// Note: this class has a natural ordering that is inconsistent with equals.
	
	@Override
	public int compareTo(Disc o) {
		
		// same colour
		if(o.colour==null) return -1;
		if(this.colour == o.colour) return 1;
		// different colour
		return 0;
	}
	

}
