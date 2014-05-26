package othello.app;

import java.util.ArrayList;
import java.util.List;

import othello.controller.Conciliator;

public class Application {
			
	public static void main(String[] args) {
		
		try{
			List<Memento> States = new ArrayList<Memento>();
			Memento state;
							
			final Conciliator ref = new Conciliator();
			
			ref.getGame().getBoard().printBoard();
			state = ref.getGame().setState(ref.getGame().getBoard());
			States.add(state);
			
			System.out.println("Your turn " + ref.getGame().getPendingPlayer().getName());
			
			do{			
				GameTimer timecount = GameTimer.getInstance();
				//to-do implement timer;
				timecount.setNull();
				
				ref.getGame().placeDisc(ref.getCmd().askForMove(), ref.getCmd().askForMove(), ref.getGame().getCurrentPlayer().getColour());
				
				ref.getGame().getBoard().printBoard();
				state = ref.getGame().setState(ref.getGame().getBoard());
				States.add(state);
				
				ref.getGame().switchPlayers();
								
				if(ref.getCmd().askToUndo()==true){
					int i = ref.getCmd().undoMoves();
					ref.getGame().setMemento(States.get(i));	
					ref.getGame().getState().printBoard();
				}
				
				System.out.println("Your turn " + ref.getGame().getPendingPlayer().getName());
				
			}while(ref.getGame().getNumBlack() < 32);
			
		}catch(NullPointerException e){
			System.out.printf(e.getMessage());
		}
	}
}
