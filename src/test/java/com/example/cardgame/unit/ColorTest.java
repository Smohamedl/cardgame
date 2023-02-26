package com.example.cardgame.unit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.cardgame.factory.ColorFactory;
import com.example.cardgame.model.Color;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ColorTest {
	@Autowired
	ColorFactory colorFactory;
	
	@Test
	public void testGetAllColors() throws Exception {
		List<Color> colors = colorFactory.getAllColors();		
		Assert.assertNotNull(colors);
		Assert.assertEquals(4, colors.size());
	}
	
	@Test
	public void testToString() {
		Color color = colorFactory.getAllColors().get(0);
		
		Assert.assertEquals(color.toString(), color.getName().toString()+ "("+ color.getPriority() +")");
	}
}
