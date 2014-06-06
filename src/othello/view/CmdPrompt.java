package othello.view;


/**
 * The CommandPrompt Class provides access to all the commands.
 * It is very useful to use this design as it allows for easy access to commands 
 * that can be reused throughout the application implementation
 * 
 * since 3.0
 * 
 */

import java.util.Scanner;

import othello.app.GameTitle;

public class CmdPrompt implements CmdListener {

	Scanner inputListener;
	
	/**
	 * Constructs a new CmdPrompt, sets up Scanner.
	 */
	public CmdPrompt(){
		this.inputListener = new Scanner(System.in);
	}
	
	/**
	 * A generic method to request the user for a move input.
	 * 
	 * @return an int that relates to a dimension of a point.
	 * 
	 */
	public int askForMove(){
		System.out.println("Please enter a integer value (0-7): ");
		int input = Integer.parseInt(readBufferListening());
		return input;
	}
	
	/**
	 * If we needed to alert the user of something.
	 * Planned usecase was such as "Time is running out". Not used/Never will be used.
	 * 
	 * @deprecated 4.0
	 */
	
	public void tellSomething(){
		// not used.
	}
	
	
	/**
	 * Reads bound input from user.
	 * 
	 */
	@Override
	public String readBufferListening() {
		String input = inputListener.next();
		return input;
		
	}
	
	
	/**
	 * Converts user input into a boolean.
	 * Asks the user if they would like to undo
	 * If user enters "Y"/"y" TRUE is returned.
	 * If user enters anything else, FALSE is returned.
	 * 
	 * @return boolean of user's response.
	 */
	public boolean askToUndo(){
		System.out.println("Would you like to undo moves? (Y/N)");
		String input = readBufferListening();
		if(input.equalsIgnoreCase("Y")){
			return true;
		}
		else return false;
	}
	
	
	/**
	 * Converts user input into int.
	 * The user is asked how many states they would like to undo.
	 * The intriguer value entered, is returned as an int.
	 * 
	 * 
	 * @return number of states to rollback as int.
	 */
	public int undoMoves(){
		System.out.println("How many states would you like to undo?");
		int input = Integer.parseInt(readBufferListening());
		return input;
	}

	
	/**
	 * Determines which game user would like to play.
	 * The user is offered a list of available games, which 
	 * can be selected from. If the user chooses Chckers, the Checkers enum value is returned.
	 * Otherwise, Othello enum value is returned.
	 * @see GameTitle
	 * @return the game the user would like to play.
	 */
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
		
	/**
	 * If the use has played an invalid move, this message is sent to user.
	 * 
	 */
	public void reportInvalidMove()
	{
		System.out.println("Invalid Move, try again.");
		
	}
		
}
	
	

