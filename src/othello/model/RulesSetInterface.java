package othello.model;


public interface RulesSetInterface {
	
	/**
	 * This method should determine which player should go first, based on rules,
	 * or potentially, a sub game (guess the highest prime number, etc)...
	 * 
	 * @return the name of the player that should be first to play.
	 */
	public String whichPlayerGoesFirst();
	
	
	
	public boolean isValidMove(Move m, Board b, Player p );
	
	/**
	 * This method should determine if another move is available to the players.
	 * Needs proper implementation.
	 * Next implementation will require additional paramaters passed.
	 * 
	 * @return if the move is possible in the current game.
	 * 
	 * 
	 */
	
	public boolean isMovePossible();
	
	/**
	 * This was originally how actions would occur on the Othello game, now implemented individually on 
	 * actionPieces. 
	 * @deprecated 3.0
	 * @see RulesSetInterface#actionPieces(Move, Board, Player) 
	 */
	public void flipPieces();
	
	
/**
 * This method should determine if a move should be actionable or not.
 * 
 * @param m Move that the player/system is making.
 * @param b Board of the move.
 * @param p Player making the move
 * @return if the action should occur.
 */
	public boolean actionPieces(Move m, Board b, Player p);
	
	/**
	 * 
	 * @param m The Move to check.
	 * @return True if the move is OK/Valid.
	 */
	public boolean checkMove(Move m);
	
}
