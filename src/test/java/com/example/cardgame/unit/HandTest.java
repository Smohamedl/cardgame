package com.example.cardgame.unit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.cardgame.factory.HandFactory;
import com.example.cardgame.model.Card;
import com.example.cardgame.model.Hand;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HandTest {
	@Autowired
	private HandFactory handFactory;
	
	@Test
	public void testGetRandomHand() throws Exception {
		Hand hand = handFactory.getRandomHand();
		Set<Object> cards = new HashSet<>();
		cards.addAll(hand.getCards());
		
		Assert.assertNotNull(hand.getCards());
		Assert.assertEquals(10, cards.size()); 
	}
	
	@Test
	public void testToString() {
		Hand hand = handFactory.getRandomHand(2);
		List<Card> handCards = hand.getCards();
		Card card1 = handCards.get(0);
		Card card2 = handCards.get(1);
		String expectedString = "{" + card1.toString() + ", " + card2.toString() + "}";
		
		Assert.assertEquals(hand.toString(), expectedString);
	}
}
