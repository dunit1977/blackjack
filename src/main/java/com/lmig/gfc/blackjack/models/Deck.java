package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private ArrayList<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();

		for (Suits suit : Suits.values()) {
			cards.add(new AceCard(suit));
			for (int i = 2; i <= 10; i += 1) {
				cards.add(new NumberCard(suit, i));
			}
			for (Faces face : Faces.values()) {
				cards.add(new FaceCard(suit, face));

			}
		}
		Collections.shuffle(cards);
	}

	public Card draw() {
		return cards.remove(0);
	
}
	public Card hit() {
		return cards.remove(0);
	}
	
	public int countCards() {
		return cards.size();
	}
	
}


