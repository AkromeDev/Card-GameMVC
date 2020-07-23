package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.Model.PlayingCards;
import com.Model.Rank;
import com.Model.Suit;

class PlayingCardsTest {

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
	@DisplayName("tests the card was created with the right rank")
	void getRankTest() {
		// ARRANGE
		PlayingCards pc = new PlayingCards(Rank.KING, Suit.HEARTS);
		
		// ACT & ASSERT
		assertEquals(pc.getRank(), Rank.KING);
	}
	
	@Test
	@DisplayName("tests the card was created with the right suit")
	void getSuitTest() {
		// ARRANGE
		PlayingCards pc = new PlayingCards(Rank.KING, Suit.HEARTS);
		
		// ACT & ASSERT
		assertEquals(pc.getSuit(), Suit.HEARTS);
	}

}
