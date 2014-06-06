package othello.app;


import othello.view.CmdPrompt;

/**
 * The starting point of the game.
 * 
 * 
 * @since 2.0
 *
 */

public class Application {
	/**
	 * Main method to start the game - either: Othello or Checkers.
	 * 
	 * @param args Providing arguments provides no effect.
	 * @since 3.0
	 */
	
	public static void main(String[] args) {
		
		CmdPrompt cmd = new CmdPrompt();
		
		GameFactory game = GameFactory.create(cmd.askForGame());
		
		game.run();	
	}
}
