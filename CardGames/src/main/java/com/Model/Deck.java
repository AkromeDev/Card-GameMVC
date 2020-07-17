package com.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	
	ArrayList<PlayingCards> card;
	
	public Deck() {
		card = new ArrayList<PlayingCards>();
		
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				System.out.println("Creating Card: " + suit + rank);
				card.add(new PlayingCards(rank, suit));
			}
		}
		
		shuffle();
	}

	public void shuffle() {
		Random random = new Random();
		
		for (int i = 0; i < card.size(); i++) {
			Collections.swap(card, random.nextInt(card.size()), random.nextInt(card.size()));
		}
	}
	
	public PlayingCards removeTopCard() {
		return card.remove(0);
	}
	
	public void returnCardToDeck(PlayingCards pc) {
		card.add(pc);
	}

}
