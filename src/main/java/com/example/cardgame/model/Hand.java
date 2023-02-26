package com.example.cardgame.model;

import java.util.List;

public class Hand {
	private List<Card> cards;
	private Integer nCards;
	public static int DEFAULT_NUM_CARDS = 10, MAX_NUM_CARDS = 26;
	
	public Hand() {
		nCards = DEFAULT_NUM_CARDS;
	}
	
	public int getNCards() {
		return nCards;
	}
	
	public void setNCards(Integer nCards) {
		this.nCards = nCards;
	}
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	@Override
	public String toString() {
		String str = "{";
		
		for(int i = 0; i < cards.size() -1; i++)
			str += cards.get(i) + ", ";
		
		str += cards.get(cards.size() - 1);
		
		str += "}";
		return str;
	}
}
