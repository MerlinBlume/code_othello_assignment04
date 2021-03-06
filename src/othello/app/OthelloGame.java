package othello.app;

import java.util.ArrayList;
import java.util.List;

import othello.controller.Conciliator;
import othello.model.Disc;
import othello.model.Move;
import othello.model.OthelloRulesSet;

/**
 *  OthelloGame implementation (not quite fully implemented)
 *  
 *  
 *  @since 4.0
 *  
 */

public class OthelloGame extends GameFactory {

	
	final Conciliator ref;
	List<Memento> states;
	Memento state;
	
	public OthelloGame() {
		
		states = new ArrayList<Memento>();
		ref = new Conciliator();
		
		
		// when new othello game is created, we define the ruleset.
		ref.setRulesSet(new OthelloRulesSet());
		
		// why we no init othello boardies heres? - Matt Jones.
		// seems to works??
		ref.getGame().getBoard().addDisc(3, 3, new Disc("White"));
		ref.getGame().getBoard().addDisc(3, 4, new Disc("Black"));
		ref.getGame().getBoard().addDisc(4, 4, new Disc("White"));
		ref.getGame().getBoard().addDisc(4, 3, new Disc("Black"));
		// bah! I did it.
		
		ref.getGame().getBoard().printBoard();
		
		state = ref.getGame().setState(ref.getGame().getBoard());
		states.add(state);
		
		System.out.println("Your turn " + ref.getGame().getPendingPlayer().getName());
	}
	
	@Override
	
	
	/**
	 * Rough mustering of implementation here. 
	 */
	boolean initMove() {
		
		@SuppressWarnings("unused")
		GameTimer timecount = GameTimer.getInstance();

		
		return true;
	}

	/**
	 * Gets the move from the user.
	 * 
	 * @see othello.app.GameFactory#askForMove(boolean)
	 */
	@Override
	boolean askForMove(boolean in) {
		
		
		Move move = new Move(ref.getCmd().askForMove(), ref.getCmd().askForMove());
		
		
		// function askForMove() could return boolean by itself e.g. if no correct move has been supplied
		ref.getGame().placeDisc(move, ref.getGame().getCurrentPlayer().getColour());
		
		return true;
	}

	
	/**
	 * 	In this case the respond is rather simple. But since we are using the template method it's easy 
	 *	to allocate where extensions to the respond should be added.
	 *
	 */
	@Override
	boolean respond(boolean in) {
		

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