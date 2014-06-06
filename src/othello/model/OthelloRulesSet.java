package othello.model;


public class OthelloRulesSet implements RulesSetInterface {


	@Override
	public String whichPlayerGoesFirst() {
		// TODO Auto-generated method stub
		return null;
	}


	
	/**
	 * The intention for this method is to check if there are any possible moves.
	 * this method has not been implemented.
	 */
	@Override
	public boolean isMovePossible() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * The intention for this method is to check if any actions need to be ran on the board.
	 * It has not been implemented.
	 */
	
	@Override
	public boolean actionPieces(Move m, Board b, Player p) {
		// TODO Auto-generated method stub
		return true;
	}

	
	/**
	 * The intention for this method is to check if the move is valid.
	 */
	
	@Override
	public boolean checkMove(Move m) {
		return true;
		// if move is valid return true.
			
	}

	/**
	 * The intention for this method is to check if peices need to be flipped.
	 * replaced by actionPieces.
	 * @deprecated
	 */
	@Override
	public void flipPieces() {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * The intention for this method is to check if the move is valid.
	 */

	@Override
	public boolean isValidMove(Move m, Board b, Player p) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
