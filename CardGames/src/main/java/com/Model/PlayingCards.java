package com.Model;

public class PlayingCards {
	
	Rank rank;
	Suit suit;
	boolean faceUp = false;
	
	public PlayingCards (Rank rank, Suit suit) {
		rank = this.rank;
		suit = this.suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public boolean getfaceUp() {
		return faceUp;
	}
	
	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}
}
