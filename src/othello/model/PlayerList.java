package othello.model;


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

	public String getPlayerName(String colour){
		String name;
		
		if(colour.equalsIgnoreCase("Black"))
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
