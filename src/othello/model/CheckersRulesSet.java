package othello.model;

import javax.print.attribute.standard.Destination;

import othello.app.GameTimer;


public class CheckersRulesSet implements RulesSetInterface {

	private Move m;
	
	@Override
	public String whichPlayerGoesFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidMove(Move m, Board board, Player p) {
		boolean validMove = true;
		// origin can't be empty.
		
		if(board.getPiece(m.getOrigin().getX(), m.getOrigin().getY())==null)
		{
			System.out.println("### DEBUG: Origin can not be empty ###");
			return false;
			
		}
		
		// can't move another players piece.
		System.out.println("###");		
		System.out.println(board.getPiece(m.getOrigin().getX(), m.getOrigin().getY()).compareTo(new Disc(p.getColour())));
		System.out.println("###");
		
		
		
		if(GameTimer.getInstance().getTime()>(System.currentTimeMillis()+60000))
		{
			validMove = true;
		}
		
		// TODO Check if the move is diag and to left or right.
		
		// check each move is valid in a loop
		
		Move tempMove = m;
		while(tempMove.getOrigin()!=null)
		{
			int originMoveX = tempMove.getOrigin().getX();
			int destinationMoveX = tempMove.getY();
			
			int originMoveY = tempMove.getOrigin().getY();
			int destinationMoveY = tempMove.getY();
			
			// check it was a diag move.
			
			if(originMoveX==destinationMoveX || originMoveY==destinationMoveY)
			{
				// can't move in a straight line, sorry!
				validMove = false;
				
				System.out.println("DEBUG: Move not horizontal");
			}
			
			if(destinationMoveX>(originMoveX+1) || destinationMoveX<(originMoveX-1))
			{
				// can't be <> 3.
				// do a jumpCheck.
			}
				
			tempMove = tempMove.getOrigin();
		}
		
		return validMove;
	}

	
	
	
	@Override
	
	
	// logic to see if there is an available move possible??
	
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

	@Override
	public boolean checkMove(Move m) {
		
		// if move is valid return true.
		
		
		return false;
	}

	@Override
	public void flipPieces() {
		// TODO Auto-generated method stub
		
	}
	

}
