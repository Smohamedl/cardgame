package com.example.cardgame.unit;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.cardgame.factory.ValueFactory;
import com.example.cardgame.model.Value;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ValueTest {
	@Autowired
	private ValueFactory valueFactory;
	
	@Test
	public void testGetAllValues() throws Exception {
		List<Value> values = valueFactory.getAllValues();		
		Assert.assertNotNull(values);
		Assert.assertEquals(13, values.size());
	}
	
	@Test
	public void testToString() {
		Value value = valueFactory.getAllValues().get(0);
		
		Assert.assertEquals(value.toString(), 
				value.getName().toString()+ "("+ value.getPriority() + ")");
	}
}
