package com.Model;

import java.util.ArrayList;

public class Hand {
	
	ArrayList<PlayingCards> cards;
	
	public Hand() {
	cards = new ArrayList<PlayingCards>();
	}
	
	public PlayingCards getCard(int index) {
		return cards.get(index);
	}
	
	public void addCard(PlayingCards pc) {
		cards.add(pc);
	}
	
	public void removeCard() {
		cards.remove(0);
	}
	
	
}
