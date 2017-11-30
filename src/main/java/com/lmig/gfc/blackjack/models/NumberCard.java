package com.lmig.gfc.blackjack.models;

public class NumberCard extends Card {
	
	private int value;
	
	public NumberCard(Suits suit, int value) {
		super(suit);
		this.value = value;
	}
	@Override
	public String getFace() {
		// TODO Auto-generated method stub
		return String.valueOf(value);
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
