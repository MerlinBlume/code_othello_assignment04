package othello.app;

import othello.model.Board;


public class Memento {
	private Board board;
	
	public Memento(Board _board){
		board = _board;
	}
	
	
	public Board getState(int undo){
		return board;
	}
}
