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
	
	public void evaluateWinner() {
		Player bestPlayer = null;
		int bestRank = -1;
		int bestSuit = -1;
		
		for (Player player: players) {
			boolean newBestPlayer = false;
			
			if (bestPlayer == null) {
				newBestPlayer = true;
				
			} else {
				PlayingCards pc = player.getCard(0);
				
				if (pc.getRank().value() == bestRank) {
					if (pc.getSuit().value() > bestSuit) {
						newBestPlayer = true;
					}
					
				} else if (pc.getRank().value() > bestRank) {
					newBestPlayer = true;
				}
			}
			
			if (newBestPlayer = true) {
				bestPlayer = player;
				PlayingCards pc = player.getCard(0);
				bestRank = pc.getRank().value();
				bestSuit = pc.getSuit().value();
			}
		}
		
		winner = bestPlayer;
		
	}
	
	public void displayWinner() {
		view.something();
	}
	
	public void rebuildDeck() {
		for (Player player : players) {
			deck.returnCardToDeck(player.removeCard()); 
		}
	}
}
