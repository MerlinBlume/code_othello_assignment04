package othello.model;

/**
 * The PlayerList class is responsible for getting the names of the players.
 * This in future releases may not exist (and code moved into CommandPrompt, etc)
 * 
 * This code determines the names of the players, and colours of these players.
 * 
 */

import java.util.Scanner;

public class PlayerList {

	private Player whitePlayer;
	private Player blackPlayer;
	private Scanner input;
	
	PlayerList(){
		
		input = new Scanner(System.in);
		
		System.out.println("Please enter a name for White Disk Player: ");
		this.whitePlayer = new Player(input.nextLine());
		 //input.nextLine();
		whitePlayer.setColour("White");
		System.out.println();
		
		System.out.println("Please enter a name for Black Disc Player: ");
		this.blackPlayer = new Player(input.nextLine());
        blackPlayer.setColour("Black");
		System.out.println();	
		
	}

	/**
	 * From the colour sent in, this method will get the player name for the colour.
	 * @param colour
	 * @return the Players name.
	 */
	public String getPlayerName(String colour){
		String name;
		
		if(colour.equalsIgnoreCase("Black"))
			name = blackPlayer.getName();
		else
			name = whitePlayer.getName();
		
		return name;
	}
	
	
	/**
	 * Will return WhitePlayer object.
	 * 
	 * @return the WhitePlayer object.
	 */
	public Player getWhitePlayer() {
		return whitePlayer;
	}

	/**
	 * Will return Black Player object.
	 * 
	 * @return the Black Player object.
	 */
	public Player getBlackPlayer() {
		return blackPlayer;
	}

	@Override
	public String toString() {
		return "PlayerList [whitePlayer=" + whitePlayer.getName() + ", blackPlayer="
				+ blackPlayer.getName() + "]";
	}
	
	
}
