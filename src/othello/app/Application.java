package othello.app;


import othello.view.CmdPrompt;



public class Application {
	// it's no Mario party - but let's get this game started.		
	public static void main(String[] args) {
		
		CmdPrompt cmd = new CmdPrompt();
		
		GameFactory game = GameFactory.create(cmd.askForGame());
		
		game.run();	
	}
}
