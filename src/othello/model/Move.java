package othello.model;


/**
 * 
 * @author Matt Jones
 * 
 * The move class can be used to store a move, from the command line?
 * This would prevent us going crazy using integers??
 * just an idea?
 *
 */
public class Move {
	private int x;
	private int y;
	private Action action;
	
	public enum Action {ADD, REMOVE };

	public void setMove(int x, int y, Action action)
	{
		this.action = action;
		this.x = x;
		this.y = y;	
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Action getAction() {
		return action;
	};
	
	
}
