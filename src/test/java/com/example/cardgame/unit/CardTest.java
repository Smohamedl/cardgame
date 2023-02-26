package com.example.cardgame.unit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.cardgame.factory.CardFactory;
import com.example.cardgame.model.Card;
import com.example.cardgame.model.Value;
import com.example.cardgame.model.Color;
import java.util.List;

@SpringBootTest // provides the spring boot context
@RunWith(SpringRunner.class) // JUnit component for running @Autowied
public class CardTest {
	@Autowired
	private CardFactory cardFactory;
	
	@Test
	public void testGetAllCards() throws Exception {
		List<Card> cards = cardFactory.getAllCards();
		
		Assert.assertEquals(52, cards.size());
	}
	
	@Test
	public void testToString() {
		List<Card> cards = cardFactory.getAllCards();
		Card card = cards.get(0);
		Value value = card.getValue();
		Color color = card.getColor();
		String expectedString =  "["+value.toString()+", "+color.toString()+"]";
		
		Assert.assertEquals(card.toString(), expectedString);
	}
}
