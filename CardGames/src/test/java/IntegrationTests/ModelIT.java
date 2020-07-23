package IntegrationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.Model.Deck;
import com.Model.PlayingCards;
import com.Model.Rank;
import com.Model.Suit;

class ModelIT {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("tests the a card is returned when removing it from the deck")
	void removeCardTest() {
		// ARRANGE
		Deck deck = new Deck();
		
		// ACT 
		PlayingCards pc = new PlayingCards(Rank.KING, Suit.HEARTS);
		deck.returnCardToBeginningOfTheDeck(pc);
		PlayingCards removedCard = deck.removeTopCard();
		
		// ASSERT
		assertEquals(removedCard.getRank(), Rank.KING);
	}
	
	@Test
	@DisplayName("tests the a card is returned when removing it from the deck")
	void removeCardSuitTest() {
		// ARRANGE
		Deck deck = new Deck();
		
		// ACT 
		PlayingCards pc = new PlayingCards(Rank.KING, Suit.HEARTS);
		deck.returnCardToBeginningOfTheDeck(pc);
		PlayingCards removedCard = deck.removeTopCard();
		
		// ASSERT
		assertEquals(removedCard.getSuit(), Suit.HEARTS);
	}
}
