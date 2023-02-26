package com.example.cardgame.service;

import com.example.cardgame.model.Hand;

public interface GameService {
	public Hand generateRandomHand();
	
	public void orderHand(Hand hand);
}