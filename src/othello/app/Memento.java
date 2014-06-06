package othello.app;

import othello.model.Board;

/**
 * Part of Memento implementation to support undo of moves.
 * 
 * @since 3.0
 *
 */

public class Memento {
	private Board board;
	
	public Memento(Board _board){
		board = _board;
	}
	
	/**
	 * GetState
	 * 
	 * @param undo
	 * @return board
	 * @since 3.0
	 */
	public Board getState(int undo){
		return board;
	}
}
