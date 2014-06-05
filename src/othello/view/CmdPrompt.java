package othello.view;


import java.util.Scanner;

import othello.app.GameTitle;

public class CmdPrompt implements CmdListener {

	Scanner inputListener;
	
	public CmdPrompt(){
		this.inputListener = new Scanner(System.in);
	}
	
	public int askForMove(){
		System.out.println("Please enter a integer value (0-7): ");
		int input = Integer.parseInt(readBufferListening());
		return input;
	}
	
	public void tellSomething(){
		//TODO
	}
	
	@Override
	public String readBufferListening() {
		String input = inputListener.next();
		return input;
		
	}
	
	public boolean askToUndo(){
		System.out.println("Would you like to undo moves? (Y/N)");
		String input = readBufferListening();
		if(input.equalsIgnoreCase("Y")){
			return true;
		}
		else return false;
	}
	
	public int undoMoves(){
		System.out.println("How many states would you like to undo?");
		int input = Integer.parseInt(readBufferListening());
		return input;
	}

	public GameTitle askForGame() {
		System.out.println("What game would you like to play? (Checkers | Othello)?");
		String input = readBufferListening();
		if(input.equalsIgnoreCase("CHECKERS")){
			return GameTitle.CHECKERS;
		}else
		{
		return GameTitle.OTHELLO;
		}
	}
		
	public void reportInvalidMove()
	{
		System.out.println("Invalid Move, try again.");
		
	}
		
}
	
	

