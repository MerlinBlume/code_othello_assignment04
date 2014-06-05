package othello.model;


public class Move {
	
	public Move(int x, int y, Move origin) {
		setMove(x, y, origin);
	}
	
	public Move(int x, int y)
	{
		setMove(x, y);
	}
	
	private Move origin;
	private int x;
	private int y;

	public void setMove(int x, int y, Move origin)
	{
		this.x = x;
		this.y = y;	
		this.origin = origin;
	}
	
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
	
	public Move getOrigin() {
		
		return origin;
	}
	
	
}
