package com.Model;

public class Player {

	String name;
	Hand hand;
	
	public Player(String name) {
		name = this.name;
		hand = new Hand();
	}
	
	public PlayingCards getCard(int index) {
		return hand.getCard(index);
	}
	
	public void addCardToHand(PlayingCards pc) {
		hand.addCard(pc);
	}
	
	public void removeCard() {
		hand.removeCard();
	}
}
