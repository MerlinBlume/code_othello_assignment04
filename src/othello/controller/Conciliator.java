package othello.controller;

import othello.model.GameState;
import othello.view.CmdPrompt;

public class Conciliator {

	private CmdPrompt cmd;
	private GameState game;
	
	public Conciliator(){
		cmd = new CmdPrompt();
		game = new GameState();
	}
	
	public String whichPlayerGoesFirst() {
		System.out.println("It's black's turn!");
		String black = "b";
		return black;
	}

	public GameState getGame() {
		return game;
	}

	public CmdPrompt getCmd() {
		return cmd;
	}
}
