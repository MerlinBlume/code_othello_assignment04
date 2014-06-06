package othello.app;

public abstract class GameFactory {

	static GameFactory game;

	// generate the right type of game.
	static GameFactory create(GameTitle title){
	
		switch (title) {
		case OTHELLO:
			game = new OthelloGame();
			break;

		case CHECKERS:
			game = new CheckerGame();
			break;
			
		default:
			game = new OthelloGame();
			break;
		}
		return game;
	}
	
	/**
	 * The abstract factory pattern got extended by a customized template method
	 * using the template we can define the coarse order in which actions need to be
	 * applied at games implemented within our little board-game API. Using boolean
	 * return values a simple communication interface between the different chained
	 * methods becomes available.
	 * Also we can hide the game-loop from the actual games implementation.
	 * 
	 * 
	 */
	
	public boolean run() {
		
		boolean flowControl;
		
		try {
			
			do {
				
				flowControl = initMove();
				flowControl = askForMove(flowControl);
				flowControl = respond(flowControl);
				flowControl = askForUndo(flowControl);
				flowControl = finalizeMove(flowControl);
			}
			
			while(flowControl == true);
			return true;
		}
		
		catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	
	/**
	 * Initial of move/turn code in this method.
	 * @since 4.0
	 * 
	 */
	abstract boolean initMove();
	
	/**
	 * Requesting player to play turn in this method
	 * 
	 * @since 4.0
	 * 
	 */
	
	abstract boolean askForMove(boolean in);
	
	/**
	 * Handling what to do after player response in this method.
	 * 
	 * @since 4.0
	 * 
	 */
	abstract boolean respond(boolean in);
	
	/**
	 * Request if the user wants to undo move in this method
	 * @since 4.0
	 * 
	 */
	abstract boolean askForUndo(boolean in);
	
	/**
	 * Finish up the player's turn in this method
	 * 
	 * @since 4.0
	 * 
	 */
	abstract boolean finalizeMove(boolean in);
}




