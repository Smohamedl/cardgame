package com.example.cardgame.model;

import java.util.HashMap;
import java.util.Map;

public class Value implements IValue {
	private int priority;
	private Name name;
	private static Map<Name, Value> instances = new HashMap<Name, Value>();
	
	public static Value getInstance(Name name) {
		if(!instances.containsKey(name))
			instances.put(name, new Value(name, 0));
		
		return instances.get(name);
	}
	
	public Value(Name name, int priority) {
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

	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}


	public static enum Name{
		Deux,
		Trois,
		Quatre,
		Cinq,
		Six,
		Sept,
		Huit,
		Neuf,
		Dix,
		Valet,
		Dame,
		Roi,
		As
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(!(o instanceof Value))
			return false;
		
		Value value = (Value)o;
		
		return value.getName().equals(getName()) && value.getPriority() == getPriority() 
				&& value.getType().equals(getType());
	}
	
	@Override
	public void setName(String strName) {
		Name name = Name.valueOf(strName);
		if(name != null)
			setName(name);
	}

	@Override
	public String getType() {
		return "VALUE";
	}
	
	@Override
	public String toString() {
		return name.toString() + "(" + priority + ")";
	}
}
