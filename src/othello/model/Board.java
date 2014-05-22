package othello.model;



public class Board {

	private Disc[][] board = new Disc[8][8];
	
	public Board(){
		board[3][3] = new Disc("White");
		board[3][4] = new Disc("Black");
		board[4][4] = new Disc("White");
		board[4][3] = new Disc("Black");
	}
	
	public void printBoard() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if (board[i][j] == null)
					System.out.print("- ");
				else
					System.out.print(board[i][j].getSymbol() + " ");
			}
			System.out.println();
		}
	}

	public void addDisc(int x, int y, String colour){
		board[x][y] = new Disc(colour);
	}
	
	public String checkField(){
		return null;
	}
	
	
}
