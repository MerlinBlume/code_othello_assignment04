package othello.app;


import othello.view.CmdPrompt;

public class Application {
			
	public static void main(String[] args) {
		
	//bang bang bang
		// Matt Jones - can I use the CmdPrompt 'legally' here???
		CmdPrompt cmd = new CmdPrompt();
		
		GameFactory game = GameFactory.create(cmd.askForGame());
		
		game.run();	
	}
}
