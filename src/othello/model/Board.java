package othello.model;

import java.util.ArrayList;

class GenericBoard<T extends Comparable<T>> {

	private int dimension;
	private ArrayList<ArrayList<Comparable<T>>> board;
	
	public GenericBoard(int dimension){
		
		this.dimension = dimension;
		
		board = new ArrayList<ArrayList<Comparable<T>>>(dimension);
		for(int i=0; i < dimension; i++) {
			
			board.add(new ArrayList<Comparable<T>>(dimension));
			for(int j = 0; j < dimension; j++){
			
				board.get(i).add(null);
			}
		}
	}
	
	// this method is generic
	public void addDisc(int x, int y, Comparable<T> p){
		board.get(x).remove(y);
		board.get(x).add(y, p);
	}
	// compared to the old one
	//
	// public void addDisc(int x, int y, String colour){
	//		board[x][y] = new Disc(colour);
	// }
	
	public T getPiece(int x, int y) {
		return (T)board.get(x).get(y);
	}
	
	public void printBoard() {
		for(int i = 0; i < dimension; i++){
			for(int j = 0; j < dimension; j++){
				if(board.get(i).get(j) == null)
					System.out.print("- ");
				else
					System.out.print(board.get(i).get(j).toString() + " ");
			}
			System.out.println();
		}
	}
	
	public T checkField(){
		return null;
	}
}

public class Board extends GenericBoard<Disc> {
	
	public Board(int dimension) {
	
		super(dimension);
		
		addDisc(3, 3, new Disc("White"));
		addDisc(3, 4, new Disc("Black"));
		addDisc(4, 4, new Disc("White"));
		addDisc(4, 3, new Disc("Black"));
	}
}