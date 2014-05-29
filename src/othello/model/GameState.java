package othello.model;
import othello.app.Memento;
import othello.view.CmdListener;



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
		if(colour.equalsIgnoreCase("W")){
			this.currentPlayer = playerList.getWhitePlayer();
			this.pendingPlayer = playerList.getBlackPlayer();
		}
		else if(colour.equalsIgnoreCase("B")){
			this.currentPlayer = playerList.getBlackPlayer();
			this.pendingPlayer = playerList.getWhitePlayer();
		}
		else
			System.out.print("Invalid colour setCurrentPlayer");
	}
	
	public void switchPlayers(){
		Player oldPlayer = currentPlayer;
		currentPlayer = pendingPlayer;
		pendingPlayer = oldPlayer;
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
	
	public void placeDisc(int x, int y, String colour){
		board.addDisc(x, y, new Disc(colour));
	}
	
	
	public void removeDisc(int x, int y)
	{
		board.removeDisc(x, y);
	}

	@Override
	public String readBufferListening() {
		// TODO This is enable the GameState to read inputs itself if needed
		return null;
	}

	
}
