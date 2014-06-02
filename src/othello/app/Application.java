package othello.app;


import othello.view.CmdPrompt;

/**
 * @author Merlin Blume, Matt Jones, Y, G, Marcus Wolfhagen
 * 
 * Application implements the Main Method, which starts the game. 
 * 
 */


public class Application {
			
	public static void main(String[] args) {
		
		CmdPrompt cmd = new CmdPrompt();
		
		GameFactory game = GameFactory.create(cmd.askForGame());
		
		game.run();	
	}
}
