package com.Controller;

import java.util.ArrayList;

import com.Model.Deck;
import com.Model.Player;
import com.Model.PlayingCards;
import com.View.View;

public class GameController {
	
	enum GameState {
		AddingPlayers,
		Cardsdealt,
		WinnerRevealed
	}
	
	Deck deck = new Deck();
	ArrayList<Player> players;
	Player winner = new Player(null);
	Player player = new Player(null);
	View view = new View();
	GameState gameState;
	
	public GameController (View view, Deck deck) {
		view = this.view;
		deck = this.deck;
		players = new ArrayList<Player>();
		gameState = GameState.AddingPlayers;
		view.setController(this);
	}
	
	public void runMe() {
		while (true) {
			switch(gameState) {
			case AddingPlayers:
				view.promptForPlayerName();
				break;
				
			case Cardsdealt:
				view.promtForFlip();
				break;
				
			case WinnerRevealed:
				view.promptForNewGame();
				break;
			}
		}
	}
	
	public void addPlayer (String playerName) {
		if (gameState == GameState.AddingPlayers) {
			Player newPlayer = new Player(playerName);
			players.add(newPlayer);
			view.showPlayerName(players.size(), newPlayer.getName());
		}
	}
	
	public void startGame() {
		if (gameState != GameState.Cardsdealt) {
			deck.shuffle();
			
			int playerIndex = 1;
			
			for (Player player : players) {
				PlayingCards card = deck.removeTopCard();
				player.addCardToHand(card);
				view.showFaceDownCardForPlayer(playerIndex++, player.getName());
			}
		
		gameState = GameState.Cardsdealt;
		
		}
	}
	
	public void flipCards() {
		int playerIndex = 1;
		
		for (Player player: players) {
			PlayingCards pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
		}
	}
	
	public void evaluateWinner() {
		Player bestPlayer = null;
		int bestRank = -1;
		int bestSuit = -1;
		
		for (Player player: players) {
			@SuppressWarnings("unused")
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
		view.showWinner(winner.getName());
	}
	
	public void rebuildDeck() {
		for (Player player : players) {
			deck.returnCardToDeck(player.removeCard()); 
		}
	}
}
