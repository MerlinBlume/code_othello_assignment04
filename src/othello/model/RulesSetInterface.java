package othello.model;


public interface RulesSetInterface {

	// add params.
	
	
	public String whichPlayerGoesFirst();
	
	public boolean isValidMove(Move m, Board b, Player p );
	
	public boolean isMovePossible();
	
	public void flipPieces();
	
	public boolean actionPieces(Move m, Board b, Player p);
	
	public boolean checkMove(Move m);

	//boolean isValidMove();
	
	
}
