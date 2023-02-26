package com.example.cardgame.model;

public class Card implements Comparable<Card> {
	private Color color;
	private Value value;
	private Integer priority;
	
	public Card() {
		priority = 0;
	}
	
	public Card(Color color, Value value) {
		super();
		this.color = color;
		this.value = value;
		priority = getValue().getPriority()*5 + getColor().getPriority();
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	
	@Override
    public int hashCode() {
		return color.getName().hashCode()*color.getPriority();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(!(o instanceof Card))
			return false;
		Card card = (Card)o;
		
		return card.getColor().equals(getColor()) && card.getValue().equals(getValue());
	}
	
	@Override
	public String toString() {
		return "[" + value.toString() + ", " + color.toString() + "]";
	}
	

	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	@Override
	public int compareTo(Card o) {
		return getPriority() - o.getPriority();
	}
}
