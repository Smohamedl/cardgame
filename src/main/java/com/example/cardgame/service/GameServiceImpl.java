package com.example.cardgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cardgame.factory.HandFactory;
import com.example.cardgame.model.Hand;

@Service
public class GameServiceImpl implements GameService {
	@Autowired(required=false)
	private HandFactory handFactory;
	
	@Override
	public Hand generateRandomHand() {
		return handFactory.getRandomHand();
	}
	
	@Override
	public void orderHand(Hand hand) {
		HandFactory.orderHand(hand);
	}

}