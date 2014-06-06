package othello.model;

public class Move {
	
	/**
	 * This constructor allows the user to generate a move that involves many moves. 
	 * 
	 * This can be useful in the situation where you need to move an object from one location to another, 
	 * or alternatively, need to move an object many locations.
	 * 
	 * @param x The X-Axis location of the move
	 * @param y The Y-Axis location of the move
	 * @param origin The previous move.
	 */
	public Move(int x, int y, Move origin) {
		setMove(x, y, origin);
	}
	
	
	/**
	 * This constructor is used to generate a single move.
	 * 
	 * A single move is useful in situations where the user would
	 * only want to action on a piece, rather than re-locate or do some comparisons.
	 * 
	 * 
	 * @param x The X-Axis location of the move
	 * @param y The Y-Axis location of the move
	 * 
	 * 
	 */
	public Move(int x, int y)
	{
		setMove(x, y);
	}
	
	
	/**
	 * The origin move is used to store origins. 
	 * By having an internal Move object, we can represent a
	 * recursive data structure. 
	 * 
	 */
	private Move origin;
	
	private int x;
	private int y;

	
	/**
	 * This method allows setting of the Move, so that the  move can be changed, 
	 * for example, when using Moves to control logic of a game or determine if moves adhere to rules.
	 * 
	 * @param x The X-axis of the move
	 * @param y the Y-Axis of the move
	 * @param origin The origin of the move.
	 */
	public void setMove(int x, int y, Move origin)
	{
		this.x = x;
		this.y = y;	
		this.origin = origin;
	}
	
	/**
	 * Thia 
	 * 
	 * 
	 * @param x The X-axis of the move
	 * @param y the Y-Axis of the move
	 * 
	 */
	
	public void setMove(int x, int y)
	{
		this.setMove(x, y, null);
	}

	public int getX() {
		return x;
	}

	
	public int getY() {
		return y;
	}
	
	
	/**
	 * getOrigin will return a Move object. The origin could contain many more moves. 
	 * This is a move that should represent a move's parent or base. 
	 * 
	 * @return The origin move. 
	 */
	public Move getOrigin() {
		
		return origin;
	}
	
	
}
