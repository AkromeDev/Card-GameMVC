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
				System.out.println("Creating Card: " + rank + " - " + suit);
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
		PlayingCards removedCard = card.remove(0);
		return removedCard;
	}
	
	public void returnCardToEndOfTheDeck(PlayingCards pc) {
		card.add(pc);
	}
	
	public void returnCardToBeginningOfTheDeck(PlayingCards pc) {
		card.add(0, pc);
	}
	
	public int numberOfCardsinDeck() {
		int numberOfCards = card.size();
		return numberOfCards;
	}

}
