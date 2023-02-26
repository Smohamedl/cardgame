package com.example.cardgame.model;

public interface IValue {
	public Object getName();
	public int getPriority();
	public void setPriority(int priority);
	public void setName(String name);
	public String getType();
}
