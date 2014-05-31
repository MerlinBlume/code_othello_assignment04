package othello.model;


public interface GameRulesInterface {

	public String whichPlayerGoesFirst();
	public boolean isValidMove();
	public boolean isMovePossible();
	//public void flipPieces();
	public void actionPieces();	
}
