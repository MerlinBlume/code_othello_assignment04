package othello.model;


public interface RulesSetInterface {

	// add params.
	
	
	public String whichPlayerGoesFirst();
	
	public boolean isValidMove(Move m, Board b );
	
	public boolean isMovePossible();
	
	public void flipPieces();
	
	public void actionPieces();
	
	public boolean checkMove(Move m);

	//boolean isValidMove();
	
	
}
