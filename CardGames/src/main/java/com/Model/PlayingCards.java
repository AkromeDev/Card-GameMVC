package com.Model;

public class PlayingCards {
	
	private final Rank rank;
	private final Suit suit;
	private boolean faceUp;
	
	public PlayingCards (Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		faceUp = false;
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
