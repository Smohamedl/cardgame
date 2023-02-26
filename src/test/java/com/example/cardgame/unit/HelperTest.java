package com.example.cardgame.unit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.cardgame.helper.Helper;
import com.example.cardgame.model.Value;
import com.example.cardgame.model.Value.Name;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class HelperTest {
	
	@Test
	public void testGenerateRandomPriorities() {
		List<Value> values = new ArrayList<>();
		Set<Integer> priorities = new HashSet<Integer>();
		
		for(Name vn : Name.values()) {
			values.add(Value.getInstance(vn));
		}
		
		(new Helper()).generateRandomValuePriorities(values);
		
		for(Value v : values) {
			Assert.assertTrue(v.getPriority() != 0);
			Assert.assertFalse(priorities.contains(v.getPriority()));
			priorities.add(v.getPriority());
		}
	}
}
