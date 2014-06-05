package othello.model;

import javax.print.attribute.standard.Destination;

import othello.app.GameTimer;


public class CheckersRulesSet implements RulesSetInterface {

	private Move m;
	
	@Override
	public String whichPlayerGoesFirst() {

		return null;
	}

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
		board.getPiece(m.getOrigin().getX(), m.getOrigin().getY()).compareTo(
																new Disc(p.getColour()))
			==0)
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
				if(destinationMoveY == originMoveY+1 || destinationMoveY == originMoveY-1)
				{
					validMove =  true;
				}
			}
			
			
			if(destinationMoveX == (originMoveX+2) || destinationMoveX == (originMoveX-2))
			{
				if(destinationMoveY == (originMoveY+2) || destinationMoveY == (originMoveY-2))
				{
					validMove = true;
				}
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




