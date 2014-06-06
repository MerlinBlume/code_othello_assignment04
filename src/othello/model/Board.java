package othello.model;

import java.util.ArrayList;

/**
 * The GenericBoard class demonstrates the use of Generics.
 * 
 * The Board is used as a Grid, to place pieces on. 
 * 
 * This could be extended to place any type of piece on, to make diferent types of games operate.
 * 
 * @since 4.0
 *
 * @param <T>
 */

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
	
	/**
	 * A Generic method that adds a disc to the board, at a given position.
	 * @param x The X axis of the placement.
	 * @param y the Y axis of the placement.
	 * @param p the Piece to place.
	 */
	public void addDisc(int x, int y, Comparable<T> p){
		board.get(x).remove(y);
		board.get(x).add(y, p);
	}
	
	// we need to compare something.
	
	// compared to the old one
	//
	// public void addDisc(int x, int y, String colour){
	//		board[x][y] = new Disc(colour);
	// }
	
	// had to give the board special powers to allow disc removal.

	/**
	 * Removes a piece from the board.
	 * 
	 * 
	 * @param x X axis of location to remove from
	 * @param y Y axis of location to remove from
	 */
	public void removeDisc(int x, int y)
	{
		
		board.get(x).set(y, null);
		//board.get(x).add(null);
	}
	
	/**
	 * Gets a piece from the board.
	 * 
	 * @param x the X axis to get the piece from.
	 * @param y the Y axis to get the piece from.
	 * @return the piece from the place specified.
	 */
	public T getPiece(int x, int y) {
		return (T) board.get(x).get(y);
	}
	
	
	/**
	 * Prints the board to Standard output.
	 * 
	 */
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

/**
 * 
 * Board is an example of extension of the Generic board.
 *
 */
public class Board extends GenericBoard<Disc> {
	
	public Board(int dimension) {
	
		super(dimension);

	}
}