package com.lmig.gfc.blackjack.models;

import java.util.List;
import java.util.LinkedList;

public class DealerHand {
	
	private LinkedList<Card> cards;

	public DealerHand() {
		cards = new LinkedList<Card>();

	}

	public void accept(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return cards;
	}

	public int getTotal() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getValue();

		}

		if (sum > 21) {

			for (Card card : cards) {
				if (card instanceof AceCard) {
					sum -= 10;
					if (sum < 21) {
						break;

					}

				}


			}
		}
		return sum;
	}

	public int numberOfCards() {
		return cards.size();
	}

	public void clearHand() {
		cards.clear();
		
	}
	
}

