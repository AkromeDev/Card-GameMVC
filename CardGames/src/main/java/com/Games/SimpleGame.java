package com.Games;

import com.Controller.GameController;
import com.Model.Deck;
import com.View.View;

public class SimpleGame {

	public static void main(String[] args) {
		GameController gc = new GameController(new View(), new Deck());
		gc.runMe();
	}
	
}
