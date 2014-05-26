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
	public void run() {
		
		try {
			
			do{	
				
				GameTimer timecount = GameTimer.getInstance();
				//to-do implement timer;
				timecount.setNull();
				
				ref.getGame().placeDisc(ref.getCmd().askForMove(), ref.getCmd().askForMove(), ref.getGame().getCurrentPlayer().getColour());
				
				ref.getGame().getBoard().printBoard();
				state = ref.getGame().setState(ref.getGame().getBoard());
				states.add(state);
				
				ref.getGame().switchPlayers();
								
				if(ref.getCmd().askToUndo()==true){
					int i = ref.getCmd().undoMoves();
					ref.getGame().setMemento(states.get(i));	
					ref.getGame().getState().printBoard();
				}
				
				System.out.println("Your turn " + ref.getGame().getPendingPlayer().getName());
				
			} while(ref.getGame().getNumBlack() < 32);
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}