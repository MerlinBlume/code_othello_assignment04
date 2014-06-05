package othello.model;


import java.util.Scanner;

public class PlayerList {

	private Player whitePlayer;
	private Player blackPlayer;
	private Scanner input;
	
	PlayerList(){
		
		input = new Scanner(System.in);
		String pOneColour;
		
		System.out.println("Please enter a name for White Disk Player: ");
		this.whitePlayer = new Player(input.nextLine());
		pOneColour = "White";//input.nextLine();
		whitePlayer.setColour(pOneColour);
		System.out.println();
		
		System.out.println("Please enter a name for Black Disc Player: ");
		this.blackPlayer = new Player(input.nextLine());
			blackPlayer.setColour("Black");
			// matt jones - deleted the following line cause its redundant.
			// System.out.println("Your colour is black!");
		System.out.println();	
		
	}

	public String getPlayerName(String colour){
		String name;
		
		if(colour.equalsIgnoreCase("b"))
			name = blackPlayer.getName();
		else
			name = whitePlayer.getName();
		
		return name;
	}
	
	
	public Player getWhitePlayer() {
		return whitePlayer;
	}

	public Player getBlackPlayer() {
		return blackPlayer;
	}

	@Override
	public String toString() {
		return "PlayerList [whitePlayer=" + whitePlayer.getName() + ", blackPlayer="
				+ blackPlayer.getName() + "]";
	}
	
	
}
