package othello.model;


public class OthelloRulesSet implements RulesSetInterface {


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

	
	@Override
	public boolean actionPieces(Move m, Board b, Player p) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean checkMove(Move m) {
		return true;
		// if move is valid return true.
			
	}

	@Override
	public void flipPieces() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isValidMove(Move m, Board b, Player p) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
