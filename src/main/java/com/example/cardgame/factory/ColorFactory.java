package com.example.cardgame.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.cardgame.helper.Helper;
import com.example.cardgame.model.Color;
import com.example.cardgame.model.Color.Name;;

// TODO check Architecture improvement merge ValueFactory and ColorFactory
@Component
public class ColorFactory {
	@Autowired
	private Helper helper;
	
	public List<Color> getAllColors() {
		List<Color> colors = new ArrayList<>();
		for(Name cm : Name.values()) {
			colors.add(Color.getInstance(cm));
		}
		
		helper.generateRandomColorPriorities(colors);
		
		return colors;
	}
}
