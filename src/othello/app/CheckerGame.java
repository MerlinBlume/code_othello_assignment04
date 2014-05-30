package othello.app;

import java.util.ArrayList;
import java.util.List;

import othello.controller.Conciliator;
import othello.model.Disc;

public class CheckerGame extends GameFactory{

	
	final Conciliator ref;
	List<Memento> states;
	Memento state;
	
	
	public CheckerGame() {
		// initialization details ...
		
		states = new ArrayList<Memento>();
		ref = new Conciliator();
		
		
		// why we no init checkers heres? - Matt Jones.
		// seems to works??
		
	    boardSetup();
		
		// bah! I did it.
		
		ref.getGame().getBoard().printBoard();
		
		state = ref.getGame().setState(ref.getGame().getBoard());
		states.add(state);
		
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
		
		return true;
	}

	@Override
	boolean respond(boolean in) {
		ref.getGame().getBoard().printBoard();
		
		return false;
	}

	@Override
	boolean askForUndo(boolean in) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean finalizeMove(boolean in) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	// i am a helper method to populate the checkers board with 
	// m and m's (or Disc's - anything Comparable is possible?)
	// Matt Jones
	
	// I based this arrangement on the "English Draughts wiki page.
	
	private void boardSetup() {	
		String[] colour = {"Black","White"};
		int[] printRows = {0,1,2};
		boolean offset = true;
		for(int i=0;i<2;i++)
		{
			for(int k=0; k<3;k++)
			{
			  for(int j = (offset) ? 1 : 0 ; j<=7; j+=2)
			  {
				ref.getGame().getBoard().addDisc(printRows[k], j , new Disc(colour[i]));		
			  }
			   offset = !offset;
			   printRows[k] = 7 - printRows[k];
			}	
		}
	}
	
}
