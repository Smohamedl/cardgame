package com.example.cardgame.model;

import java.util.HashMap;
import java.util.Map;


public class Color implements IValue {
	private Name name;
	private int priority;
	private static Map<Name, Color> instances = new HashMap<Name, Color>();
	
	public static Color getInstance(Name name) {
		if(!instances.containsKey(name))
			instances.put(name, new Color(name, 0));
		
		return instances.get(name);
	}
	
	public Color(Name name, int priority) {
		super();
		this.name = name;                                                                                                     
		this.priority = priority;
	}
	 
	@Override
	public Name getName() {
		return name;
	}
	
	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}
	

	public static enum Name{
		Carreaux,
		Coeur,
		Pique,
		Trefle
	}


	@Override
	public String getType() {
		return "COLOR";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		
		if(!(o instanceof Color))
			return false;
		
		Color color = (Color)o;
		
		return color.getName().equals(getName()) && color.getPriority() == getPriority()
				&& color.getType().equals(getType());
	}

	@Override
	public void setName(String strName) {
		Name name = Name.valueOf(strName);
		if(name != null)
			setName(name);
	}
	
	@Override
	public String toString() {
		return name.toString() + "(" + priority + ")";
	}
}
