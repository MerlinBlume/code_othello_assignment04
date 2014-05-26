package othello.model;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class Disc implements Comparable<Disc> {
	
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
	
	// again ... this is more generic
	@Override
	public String toString() {
		if (this.colour.equalsIgnoreCase("White") || this.colour.equalsIgnoreCase("w"))
			this.symbol = "X";
		else
			this.symbol = "O";
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

	@Override
	public int compareTo(Disc o) {
		
		// same colour
		if(this.colour == o.colour) return 1;
		
		// different colour
		return 0;
	}
}
