package com.example.cardgame.unit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cardgame.model.Card;
import com.example.cardgame.model.Hand;
import com.example.cardgame.service.GameServiceImpl;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class GameServiceTest {
	@Autowired
	private GameServiceImpl gameService;
	
	@Test
	public void testOrderHand() {
		Hand hand = gameService.generateRandomHand();
		
		Assert.assertNotNull(hand);
		Assert.assertNotNull(hand.getCards());
		Assert.assertFalse(hand.getCards().isEmpty());
		
		gameService.orderHand(hand);
		List<Card> cards = hand.getCards();
		
		for(int i = 0; i < hand.getCards().size()-1; i++){
			Card card = cards.get(i), nextCard = cards.get(i+1);
			Assert.assertTrue(card.getPriority() < nextCard.getPriority());
		}
	}
}
