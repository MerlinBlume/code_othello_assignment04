package othello.app;

import java.util.ArrayList;
import java.util.List;

import othello.controller.Conciliator;
import othello.model.Disc;
import othello.model.CheckersRulesSet;
import othello.model.Move;

/**
 * CheckersGame is a concrete implementation used by the GameFactory
 * It can be used to play a game of Checkers.
 * 
 * @since 4.0
 * 
 * 
 */

public class CheckerGame extends GameFactory{
	
	final Conciliator ref;
	List<Memento> states;
	Memento state;
	
	// here we get the game extablished.
	public CheckerGame() {
		// initialization details ...
		
		states = new ArrayList<Memento>();
		ref = new Conciliator();
		ref.setRulesSet(new CheckersRulesSet());
		
	    boardSetup();
				
		ref.getGame().getBoard().printBoard();
		Memento startState = new Memento(ref.getGame().getBoard());
		
		states.add(startState);
		
	}

	/**
	 * The initMove is not used in this implementation, but could 
	 * provide initialization of move functionality. 
	 * 
	 * @since 4.0
	 * @see GameFactory
	 */
	
	
	@Override
	boolean initMove() {
		// TODO 
		return false;
	}

	/**
	 * this method asks the user to move, and checks rules.
	 * @see GameFactory
	 */
	
	@Override
	boolean askForMove(boolean in) {
		Move mFull = null;
		
		boolean allClear = false;
		while(!allClear)
		{
			System.out.println("Your turn " + ref.getGame().getCurrentPlayer().getName());
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
		
		//if you you need to jump, the below code will need to be executed.
		
		if(ref.getRulesSet().actionPieces(mFull,ref.getGame().getBoard() ,ref.getGame().getCurrentPlayer()))
		{
			int midPointX = (mFull.getX()+mFull.getOrigin().getX())/2; 
			int midPointY = (mFull.getY()+mFull.getOrigin().getY())/2;
			Move mini = new Move(midPointX, midPointY);
			System.out.println("Removing from: " + midPointX + ":" + midPointY);
			ref.getGame().removeDisc(mini);
		}
		
		
		System.out.println(ref.getGame().getCurrentPlayer().getColour());
		ref.getGame().removeDisc(mFull.getOrigin());	
		ref.getGame().placeDisc(mFull, ref.getGame().getCurrentPlayer().getColour());

		Memento postMove = new Memento(ref.getGame().getBoard());
		states.add(postMove);
		
		return allClear;
	}

	/**
	 *  Response method completes any updates that need to occur before turn ends.
	 *  @see GameFactory
	 */
	@Override
	boolean respond(boolean in) {
		ref.getGame().getBoard().printBoard();
		
		return false;
	}

	/**
	 * This method *should* allow user to take advantage of undo functions.
	 * This is implemented using Memento.
	 * 
	 * At this stage, Memento is not coded correctly and does not operate.
	 * .
	 * @see othello.app.GameFactory#askForUndo(boolean)
	 * @see Memento
	 */
	@Override
	boolean askForUndo(boolean in) {
		
		
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
	
	/**
	 * 
	 * This should be the code that completes the move/turn of the game.
	 * 
	 * @see othello.app.GameFactory#finalizeMove(boolean)
	 */
	@Override
	boolean finalizeMove(boolean in) {
		ref.getGame().switchPlayers();
		
		// implement a rule check here?
		// end game, etc.
		
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
