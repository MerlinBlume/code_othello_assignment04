package othello.controller;

import othello.model.GameState;
import othello.model.RulesSetInterface;
import othello.view.CmdPrompt;

public class Conciliator {

	private CmdPrompt cmd;
	private GameState game;
	private RulesSetInterface rulesSet;
	

	public Conciliator(){
		cmd = new CmdPrompt();
		game = new GameState();
	}
	
	public String whichPlayerGoesFirst() {
		//System.out.println("It's black's turn!");
		String black = "Black";
		return black;
	}

	public GameState getGame() {
		return game;
	}

	public CmdPrompt getCmd() {
		return cmd;
	}

	public RulesSetInterface getRulesSet() {
		return rulesSet;
	}

	public void setRulesSet(RulesSetInterface rulesSet) {
		this.rulesSet = rulesSet;
	}
	
}
