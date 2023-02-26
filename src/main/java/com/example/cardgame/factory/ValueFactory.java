package com.example.cardgame.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.cardgame.helper.Helper;
import com.example.cardgame.model.Value;
import com.example.cardgame.model.Value.Name;

@Component
public class ValueFactory {
	@Autowired
	private Helper helper;
	
	public List<Value> getAllValues() {
		List<Value> values = new ArrayList<>();
		for(Name vn : Name.values()) {
			values.add(Value.getInstance(vn));
		}
				
		helper.generateRandomValuePriorities(values);
		
		return values;
	}
}
