package othello.model;


public class OthelloRulesSet implements RulesSetInterface {

	private Move m;
	
	@Override
	public String whichPlayerGoesFirst() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isMovePossible() {
		// TODO Auto-generated method stub
		return false;
	}

/*	
 * Removed this to create a more generic actionPieces() method
 * Matt Jones
 * 
 * @Override
	public void flipPieces() {
		// TODO Auto-generated method stub
		
	}*/
	
	@Override
	public void actionPieces() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public boolean checkMove(Move m) {
		
		// if move is valid return true.
		
		
		return false;
	}

	@Override
	public void flipPieces() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isValidMove(Move m, Board b) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
