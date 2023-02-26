package com.example.cardgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardgame.model.Hand;
import com.example.cardgame.service.GameServiceImpl;

@RestController
public class GameController {
	@Autowired
	private GameServiceImpl gameService;
	private Hand hand;
	
    @RequestMapping("/randomgeneration/generate")
    private String generateRandomHand() {
    	hand = gameService.generateRandomHand();
        return hand.toString();
    }
    
    @RequestMapping("/randomgeneration/hand")
    public String getHand() {
    	if(hand == null)
    		generateRandomHand();
		return hand.toString();
    }
    
    @RequestMapping("/randomgeneration/orderhand")
    public String orderHand() {
    	gameService.orderHand(hand);
		return hand.toString();
    	
    }

}
