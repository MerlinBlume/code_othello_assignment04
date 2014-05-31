package othello.model;


public class GameRules implements GameRulesInterface {

	private Move m;
	
	@Override
	public String whichPlayerGoesFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
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

	public Move getM() {
		return m;
	}

	public void setM(Move m) {
		this.m = m;
	}
	

}
