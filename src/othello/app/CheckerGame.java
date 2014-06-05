package othello.app;

import java.util.ArrayList;
import java.util.List;

import othello.controller.Conciliator;
import othello.model.Disc;
import othello.model.CheckersRulesSet;
import othello.model.Move;

/**
 * The checkers game demonstrates the use AbstractFactory.
 * 
 * 
 */


public class CheckerGame extends GameFactory{

	
	final Conciliator ref;
	List<Memento> states;
	//Memento state;
	
	
	public CheckerGame() {
		// initialization details ...
		
		states = new ArrayList<Memento>();
		ref = new Conciliator();
		ref.setRulesSet(new CheckersRulesSet());
		
		
	    boardSetup();
		
		
		ref.getGame().getBoard().printBoard();
		Memento startState = new Memento(ref.getGame().getBoard());
		
		states.add(startState);
		
		
		System.out.println("Your turn " + ref.getGame().getPendingPlayer().getName());
		
		
	}


	
	@Override
	boolean initMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean askForMove(boolean in) {
		Move mFull = null;
		
		boolean allClear = false;
		while(!allClear)
		{
			System.out.println("Your turn " + ref.getGame().getCurrentPlayer().getName());
			//System.out.println(ref.getGame().getCurrentPlayer().getColour());
			GameTimer.getInstance().setGameTime();
			
			Move mOrigin = new Move(ref.getCmd().askForMove(), ref.getCmd().askForMove());
		    mFull = new Move(ref.getCmd().askForMove(), ref.getCmd().askForMove(), mOrigin);	
			
		    
		    
		    if(ref.getRulesSet().isValidMove(mFull, ref.getGame().getBoard(),  ref.getGame().getCurrentPlayer()))
			{
		    	allClear=true;
		    	
			}else{
				ref.getCmd().reportInvalidMove();
				}
			
		}
		
		System.out.println(ref.getGame().getCurrentPlayer().getColour());
		
		ref.getGame().removeDisc(mFull);	
		ref.getGame().placeDisc(mFull, ref.getGame().getCurrentPlayer().getColour());

		Memento postMove = new Memento(ref.getGame().getBoard());
		states.add(postMove);
		
		return allClear;
	}

	@Override
	boolean respond(boolean in) {
		ref.getGame().getBoard().printBoard();
		
		return false;
	}

	@Override
	boolean askForUndo(boolean in) {
		
		//aint working. :(
		
		return false;
	}
	

	@Override
	boolean finalizeMove(boolean in) {
		ref.getGame().switchPlayers();
		
		
		// implement a rule check here?
		//if(ref.getGame().getNumBlack() < 32) return false;
		
		
		return true;
		
	}
	
	
	
	// boardSetup() is a helper method to place disc's on the board.
	private void boardSetup() {	
		String[] colour = {"Black","White"};
		int[] printRows = {0,1,2};
		boolean offset = true;
		for(int i=0;i<2;i++)    // loop for each player
		{
			for(int k=0; k<3;k++) // loop for each row (&^)
			{
			  for(int j = (offset) ? 1 : 0 ; j<=7; j+=2) // loop for each disc, (&^^)
			  {
				ref.getGame().getBoard().addDisc(printRows[k], j , new Disc(colour[i]));		
			  }
			   // inverse the positioning offset 
			   offset = !offset;
			   // inverse the row to print on
			   printRows[k] = 7 - printRows[k];
			}	
		}
	}
	
}
