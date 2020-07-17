package com.Controller;

import java.util.ArrayList;

import com.Model.Deck;
import com.Model.Player;
import com.Model.PlayingCards;

class View {
	public void something() {}
	public void setController(GameController gc) {}
}

public class GameController {
	
	enum GameState {
		AddingPlayers,
		Cardsdealt,
		WinnerRevealed
	}
	
	Deck deck;
	ArrayList<Player> players;
	Player winner;
	View view;
	GameState gameState;
	
	public GameController (View view, Deck deck) {
		view = this.view;
		deck = this.deck;
		players = new ArrayList<Player>();
		gameState = GameState.AddingPlayers;
		view.setController(this);
	}
	
	public void run() {
		while (true) {
			switch(gameState) {
			case AddingPlayers:
				view.something();
				break;
				
			case Cardsdealt:
				view.something();
				break;
				
			case WinnerRevealed:
				view.something();
				break;
			}
		}
	}
	
	public void addPlayer (String playerName) {
		if (gameState == GameState.AddingPlayers) {
			players.add(new Player(playerName));
			view.something();
		}
	}
	
	public void startGame() {
		if (gameState != GameState.Cardsdealt) {
			deck.shuffle();
			
			int playerIndex = 1;
			
			for (Player player : players) {
				player.addCardToHand(deck.removeTopCard());
				view.something();
			}
		
		gameState = GameState.Cardsdealt;
		
		}
	}
	
	public void flippingcard() {
		for (Player player: players) {
			PlayingCards pc = player.getCard(0);
			pc.flip();
			view.something();
		}
	}
}
