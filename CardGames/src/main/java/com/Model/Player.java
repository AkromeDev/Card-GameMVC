package com.Model;

public class Player {

	String name;
	Hand hand;
	
	public Player(String name) {
		this.name = name;
		this.hand = new Hand();
	}
	
	public PlayingCards getCard(int index) {
		return hand.getCard(index);
	}
	
	public void addCardToHand(PlayingCards pc) {
		hand.addCard(pc);
	}
	
	public PlayingCards removeCard() {
		return hand.removeCard();
	}
	
	public String getName() {
		return name;
	}
}
