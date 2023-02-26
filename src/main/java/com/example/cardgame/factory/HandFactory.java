package com.example.cardgame.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.cardgame.helper.Helper;
import com.example.cardgame.model.Card;
import com.example.cardgame.model.Hand;

@Component
public class HandFactory {
	@Autowired
	private CardFactory cardFactory;
	
	public Hand getRandomHand() {
		return getRandomHand(Hand.DEFAULT_NUM_CARDS);
	}
	
	public Hand getRandomHand(Integer numberOfCards) {
		Helper helper = new Helper();
		Hand hand = new Hand();
		ArrayList<Card> pickedCards = new ArrayList<>();
		
		List<Card> cards = cardFactory.getAllCards();
		
		for(int i = 0; i < numberOfCards; i++) {
			Card pickedCard = helper.getRandomCardFromList(cards);
			pickedCards.add(pickedCard);
			cards.remove(pickedCard);
		}
		
		hand.setCards(pickedCards);
		
		return hand;
	}
	
	public static void setHandCards(Hand hand, List<Card> cards) {
		hand.setCards(cards);
	}
	
	public static void setHandNCards(Hand hand, Integer nCards) throws Exception{
		if(nCards > Hand.MAX_NUM_CARDS)
			throw new Exception("Number of cards exceeds maximum allowed");
		hand.setNCards(nCards);
	}
	
	public static void orderHand(Hand hand) {
		List<Card> orderedCards = hand.getCards().stream().sorted().collect(Collectors.toList());
		hand.setCards(orderedCards);
	}
	
}
