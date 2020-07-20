package com.Controller;

import java.util.ArrayList;

import com.Model.Deck;
import com.Model.Player;
import com.Model.PlayingCards;

class View {
	public void something() {}
	public void setController(GameController gc) {}
	public void promptForPlayerName() {
		// TODO Auto-generated method stub
		
	}
	public void promtForFlip() {
		// TODO Auto-generated method stub
		
	}
	public void promptForNewGame() {
		// TODO Auto-generated method stub
		
	}
	public void showPlayerName(int size, String playerName) {
		// TODO Auto-generated method stub
		
	}
	public void showFaceDownCardForPlayer(int i, String name) {
		// TODO Auto-generated method stub
		
	}
	public void showCardForPlayer(int i, String name, String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	public void showWinner(String name) {
		// TODO Auto-generated method stub
		
	}
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
			players.add(new Player(playerName));
			view.showPlayerName(players.size(), playerName);
		}
	}
	
	public void startGame() {
		if (gameState != GameState.Cardsdealt) {
			deck.shuffle();
			
			int playerIndex = 1;
			
			for (Player player : players) {
				player.addCardToHand(deck.removeTopCard());
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
