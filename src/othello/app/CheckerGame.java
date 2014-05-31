package othello.app;

import java.util.ArrayList;
import java.util.List;

import othello.controller.Conciliator;
import othello.model.Disc;

public class CheckerGame extends GameFactory{

	
	final Conciliator ref;
	List<Memento> states;
	//Memento state;
	
	
	public CheckerGame() {
		// initialization details ...
		
		states = new ArrayList<Memento>();
		ref = new Conciliator();
		
		
		// why we no init checkers heres? - Matt Jones.
		// seems to works??
		
	    boardSetup();
		
		// bah! I did it.
		
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
		
		ref.getGame().removeDisc(ref.getCmd().askForMove(), ref.getCmd().askForMove());
		ref.getGame().placeDisc(ref.getCmd().askForMove(), ref.getCmd().askForMove(), ref.getGame().getCurrentPlayer().getColour());
		
		Memento postMove = new Memento(ref.getGame().getBoard());
		states.add(postMove);
		return true;
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
		
		if(in != true)ref.getGame().switchPlayers();
		System.out.println("Your turn " + ref.getGame().getPendingPlayer().getName());
		
		
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
