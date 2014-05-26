package othello.app;

import othello.app.GameFactory.GameTitle;

public class Application {
			
	public static void main(String[] args) {
		
		GameFactory othello = GameFactory.create(GameTitle.OTHELLO);
		othello.run();	
	}
}
