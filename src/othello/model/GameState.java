package othello.model;
import othello.app.Memento;
import othello.view.CmdListener;

/**
 * The GameState class manages the state of the game.
 * Including who is playing, and how to swich who is playing.
 * 
 *
 */


public class GameState implements CmdListener {

	private int numWhite;
	private int numBlack;
	private int totalNum;
	private PlayerList playerList;
	private Player currentPlayer;
	private Player pendingPlayer;
	private Board board;
	int undo = 0;
	
	public GameState(){
		this.board = new Board(8);
		this.numWhite = 0;
		this.numBlack = 0;
		this.totalNum = numWhite + numBlack;
		this.playerList = new PlayerList();
		this.currentPlayer = playerList.getWhitePlayer();
		this.pendingPlayer = playerList.getBlackPlayer();
	}
	
	
	public Memento setState(Board _board){
		Memento _memento = new Memento(board);
		board = _board;
		return _memento;
	}
	
	public Board getState(){
		return board;
	}
	
	public void setMemento(Memento preState){
		board = preState.getState(undo);
	}
	
	public void whoWon(){
		if (numWhite < numBlack)
			System.out.print("Black Wins!");
		else
			System.out.print("White Wins!");
	}
	
	public void setCurrentPlayer(String colour){
		if(colour.equalsIgnoreCase("White")){
			this.currentPlayer = playerList.getWhitePlayer();
			this.pendingPlayer = playerList.getBlackPlayer();
		}
		else if(colour.equalsIgnoreCase("Black")){
			this.currentPlayer = playerList.getBlackPlayer();
			this.pendingPlayer = playerList.getWhitePlayer();
		}
		else
			System.out.print("Invalid colour setCurrentPlayer");
	}
	
	public void switchPlayers(){
		
		if(currentPlayer.getColour().equalsIgnoreCase("White"))
		{
			setCurrentPlayer("Black");
		} else
		{
			setCurrentPlayer("White");
		}
		
		
	}
	
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	public Player getPendingPlayer(){
		return pendingPlayer;
	}

	public int getNumWhite() {
		return numWhite;
	}

	public int getNumBlack() {
		return numBlack;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public PlayerList getPlayerList() {
		return playerList;
	}

	public Board getBoard() {
		return board;
	}
	
	public void placeDisc(Move m, String colour){
		
		
		board.addDisc(m.getX(), m.getY(), new Disc(colour));
	}
	
	
	public void removeDisc(Move m)
	{
		board.removeDisc(m.getX(), m.getY());
	}

	@Override
	public String readBufferListening() {
		// TODO This is enable the GameState to read inputs itself if needed
		return null;
	}

	
}
