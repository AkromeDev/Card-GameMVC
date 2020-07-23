package UnitTests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.Model.Deck;
import com.Model.PlayingCards;

public class DeckTest {

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
	@DisplayName("tests if the right number of cards is being created")
	void numberOfCardsInDeckTest() {
		// ARRANGE
		Deck deck = new Deck();
		
		// ACT & ASSERT
		assertEquals(deck.numberOfCardsinDeck(), 52);
	}
	
	@Test
	@DisplayName("tests if a card is returned when removing it from the deck")
	void removeCardTest() {
		// ARRANGE
		Deck deck = new Deck();
		
		// ACT 
		PlayingCards removedCard = deck.removeTopCard();
		
		// ASSERT
		assertNotNull(removedCard);
	}

}
