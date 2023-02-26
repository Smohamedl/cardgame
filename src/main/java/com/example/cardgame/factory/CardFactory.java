package com.example.cardgame.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.cardgame.model.*;


@Component
public class CardFactory {
	@Autowired
	private ColorFactory colorFactory;
	
	@Autowired
	private ValueFactory valueFactory;
	
	public List<Card> getAllCards(){
		List<Color> colors = colorFactory.getAllColors();
		List<Value> values = valueFactory.getAllValues();
		List<Card> cards = new ArrayList<>();
		
		for(Color color : colors) {
			for(Value value : values){
				cards.add(new Card(color, value));
			}
		}
		
		return cards;
	}
}
