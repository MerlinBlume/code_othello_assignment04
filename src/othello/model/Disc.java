package othello.model;


public class Disc {
	private String colour;
	private String symbol;
	
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
		if (this.colour.equalsIgnoreCase("Black")|| this.colour.equalsIgnoreCase("b"))
				this.colour = "Black";
		else
			this.colour = "White";
	}
		
	public String getSymbol(){
		if (this.colour.equalsIgnoreCase("White") || this.colour.equalsIgnoreCase("w"))
			this.symbol = "X";
		else
			this.symbol = "O";
		return symbol;
	}
	
}
