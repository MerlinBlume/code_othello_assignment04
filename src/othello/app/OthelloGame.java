package othello.app;

import java.util.ArrayList;
import java.util.List;

import othello.controller.Conciliator;

public class OthelloGame extends GameFactory {

	final Conciliator ref;
	List<Memento> states;
	Memento state;
	
	public OthelloGame() {
		
		states = new ArrayList<Memento>();
		ref = new Conciliator();
		
		ref.getGame().getBoard().printBoard();
		state = ref.getGame().setState(ref.getGame().getBoard());
		states.add(state);
		
		System.out.println("Your turn " + ref.getGame().getPendingPlayer().getName());
	}
	
	@Override
	boolean initMove() {
		
		GameTimer timecount = GameTimer.getInstance();
		//to-do implement timer;
		timecount.setNull();
		
		return true;
	}

	@Override
	boolean askForMove(boolean in) {
		
		// function askForMove() could return boolean by itself e.g. if no correct move has been supplied
		ref.getGame().placeDisc(ref.getCmd().askForMove(), ref.getCmd().askForMove(), ref.getGame().getCurrentPlayer().getColour());
		
		return true;
	}

	@Override
	boolean respond(boolean in) {
		
		// In this case the respond is rather simple. But since we are using the template method it's easy to allocate where
		// extensions to the respond should be added.
		ref.getGame().getBoard().printBoard();
		
		return true;
	}

	@Override
	boolean askForUndo(boolean in) {
		
		// managing undo
		state = ref.getGame().setState(ref.getGame().getBoard());
		states.add(state);
		
		boolean undo = ref.getCmd().askToUndo();				
		if(undo==true){
			int i = ref.getCmd().undoMoves();
			ref.getGame().setMemento(states.get(i));	
			ref.getGame().getState().printBoard();
			
			return true;
		}
		
		return false;
	}

	@Override
	boolean finalizeMove(boolean in) {
		
		// Finalizing the move
		if(in != true)ref.getGame().switchPlayers();
		System.out.println("Your turn " + ref.getGame().getPendingPlayer().getName());
		
		if(ref.getGame().getNumBlack() < 32) return false;
		return true;
	}
}