package othello.app;

public abstract class GameFactory {

	static GameFactory game;
	
	public static enum GameTitle {
	    OTHELLO, CHECKER 
	}
	
	static GameFactory create(GameTitle title){
	
		switch (title) {
		case OTHELLO:
			game = new OthelloGame();
			break;

		case CHECKER:
			game = new CheckerGame();
			break;
			
		default:
			game = new OthelloGame();
			break;
		}
		return game;
	}
	abstract public void run();
}