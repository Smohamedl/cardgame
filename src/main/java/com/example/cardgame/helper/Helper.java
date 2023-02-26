package com.example.cardgame.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.example.cardgame.model.Card;
import com.example.cardgame.model.Color;
import com.example.cardgame.model.IValue;
import com.example.cardgame.model.Value;

@Component
public class Helper {
	private Random r;
	
	public Helper() {
		r = new Random();
	}
	
	public int getRandomInt(int bound) {
		return r.nextInt(bound);
	}
	
	public Object getRandomObjectFromList(List<Object> cards) {
		Integer vIndex = r.nextInt(cards.size());
		
		return cards.get(vIndex);
	}
	
	public Card getRandomObjectFromList1(List<Card> cards) {
		Integer vIndex = r.nextInt(cards.size());
		
		return cards.get(vIndex);
	}
	
	public void generateRandomPriorities(List<IValue> list) {
		List<Integer> indexes = new ArrayList<Integer>();
		
		for(int i = 0; i < list.size(); i++) {
			indexes.add(i+1);
		}
		
		for(IValue value : list) {
			Integer index = r.nextInt(indexes.size());
			Integer randPriority = indexes.get(index); 
			value.setPriority(randPriority);
			indexes.remove(randPriority);
		}
	}
	
//	public void oldGenerateRandomPriorities(List<IValue> list) {
//		if(list == null || list.isEmpty())
//			return;
//		
//		int bound = list.size();
//		boolean[] picked = new boolean[bound];
//		Arrays.fill(picked, false);
//		picked[0] = true;
//		
//		for(IValue v : list) {
//			Integer vIndex = r.nextInt(bound);
//			int j = 0;
//			while(picked[(vIndex++) % bound] && j++ <= bound);
//			vIndex = (vIndex == 0 ? 13 : vIndex - 1);
//			v.setPriority(vIndex);
//			picked[vIndex-1] = true;
//		}
//	}
	
	@SuppressWarnings("unchecked")
	public Card getRandomCardFromList(List<Card> cards) {
		return (Card)getRandomObjectFromList((List<Object>)(List<?>)cards);
	}
	
	@SuppressWarnings("unchecked")
	public void generateRandomValuePriorities(List<Value> list) {
		generateRandomPriorities((List<IValue>)(List<?>)list);
	}
	
	@SuppressWarnings("unchecked")
	public void generateRandomColorPriorities(List<Color> list) {
		generateRandomPriorities((List<IValue>)(List<?>)list);
	}
}
