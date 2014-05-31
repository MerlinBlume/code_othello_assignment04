package othello.model;


public interface RulesSetInterface {

	public String whichPlayerGoesFirst();
	public boolean isValidMove();
	public boolean isMovePossible();
	public void flipPieces();
	public void actionPieces();
	
	public boolean checkMove(Move m);
	
	
}
