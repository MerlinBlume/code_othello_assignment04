package othello.model;

import othello.app.GameTimer;

/**
 * CheckersRuleSet is an implemetation of the RuleSetInteface, that provides rules for Checkers.
 * The rules, are turn based checked. 
 * 
 * The CheckersRuleSet is part of the Strategy Design Pattern. 
 * 
 * @since 4.0
 *
 */

public class CheckersRulesSet implements RulesSetInterface {

	private Move m;
	
	@Override
	public String whichPlayerGoesFirst() {

		return null;
	}

	
	/**
	 * Checks if the move is valid, ie: it can be played.
	 * 
	 * @param m The move (could be an iterated set of moves).
 	 * @param board The board at time of play (used to check against)
	 * @param p The player at time of play.
	 */
	@Override
	public boolean isValidMove(Move m, Board board, Player p) {
		boolean validMove = false;
		// origin can't be empty.
		
		if(board.getPiece(m.getOrigin().getX(), m.getOrigin().getY())==null)
		{
			return false;
			
		}
		
		//destination must be vacant.
		if(board.getPiece(m.getX(), m.getY())!=null)
		{
			return false;
		}
		
		// can't move another player's piece.
		if(
		board.getPiece(m.getOrigin().getX(), m.getOrigin().getY()).compareTo(new Disc(p.getColour()))==0)
		{
			return false;
		}

		
		
		// player can't take too long
		
		if(GameTimer.getInstance().getTime()>(System.currentTimeMillis()+60000))
		{
			return false;
		}
		
		
		
		// check each move is valid in a loop
		// this is to handle situation where jumping allows
		// more moves
		// TODO: Implement jumping.
		
		Move tempMove = m;
		while(tempMove.getOrigin()!=null)
		{
			int originMoveX = tempMove.getOrigin().getX();
			int originMoveY = tempMove.getOrigin().getY();
			
			int destinationMoveX = tempMove.getX();
			int destinationMoveY = tempMove.getY();
			
			// check it was a diag proportional move.
			

			
			
			if(destinationMoveX == (originMoveX+1) || destinationMoveX == (originMoveX-1))
			{
				if(destinationMoveY == (originMoveY+1) || destinationMoveY == (originMoveY-1))
				{
					validMove =  true;
				}
			}
			
			if (!validMove){validMove = actionPieces(tempMove, board, p);}
			
			tempMove = tempMove.getOrigin();
		}
		
		return validMove;
	}

	
	

	
	
	/**
	 * This will check if a move is possible.
	 * 
	 */
	
	@Override
	public boolean isMovePossible() {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * The actionPieces method will return true if the object in the middle of a move 
	 * is a 'jumpable' piece.
	 */
	
	@Override
	public boolean actionPieces(Move m, Board b, Player p) {
		
		int originMoveX = m.getOrigin().getX();
		int originMoveY = m.getOrigin().getY();
		
		int destinationMoveX = m.getX();
		int destinationMoveY = m.getY();
		
		if(destinationMoveX == (originMoveX+2) || destinationMoveX == (originMoveX-2))
		{
			if(destinationMoveY == (originMoveY+2) || destinationMoveY == (originMoveY-2))
			{
				int midpointX = (destinationMoveX+originMoveX)/2;
				int midpointY = (destinationMoveY+originMoveY)/2;
				
				
				if(b.getPiece(midpointX, midpointY).compareTo(new Disc(p.getColour()))==0)
				{
					return true;
				}
			}
			
		}
		
		return false;
		
	}
	
	
	/**
	 * Not used, but since we documented it in the original UML, this should stay.
	 * 
	 * @deprecated 4.0
	 * 
	 * @return Move
	 */
	
	public Move getM() {
		return m;
	}
	
	
	/**
	 * Not used, but since we documented it in the original UML, this should stay.
	 * 
	 * @deprecated 4.0
	 * 
	 * 
	 */
	
	public void setM(Move m) {
		this.m = m;
	}

	@Override
	/**
	 * Not Yet Implemented
	 * 
	 * Will check the move is valid, post movement 
	 * (ie: didn't breach any rules that need to be considered retrospectively.)
	 * 
	 */
	
	public boolean checkMove(Move m) {
		
		// if move is valid return true.
		
		
		return false;
	}

	/**
	 * Not used, this is a hangover method from original implementation.
	 * 
	 * @deprecated 4.0 
	 */
	@Override
	public void flipPieces() {
		// TODO Auto-generated method stub
		
	}
	

}




