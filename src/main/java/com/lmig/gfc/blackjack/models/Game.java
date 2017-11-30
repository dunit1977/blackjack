package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;

public class Game {

	private Deck decker;
	private PlayerHand playah;
	private DealerHand dealah;

	public Game() {
		super();
		this.decker = new Deck();
		this.playah = new PlayerHand();
		this.dealah = new DealerHand();
	}

	public void deal() {
		// Card card = decker.draw();
		playah.accept(decker.draw());
		// Card secondcard = decker.draw();
		playah.accept(decker.draw());
		// Card thirdcard = decker.draw();
		dealah.accept(decker.draw());
		// Card fourthcard = decker.draw();
		dealah.accept(decker.draw());

	}

	public void hit() {
		playah.accept(decker.draw());
	}
	// draw one card at a time
	// remove card from dec add card to player hand
	// remove card from dec add card to dealer hand

	
	
	public void stand() {
		dealah.accept(decker.draw());
	}
		
	public Deck getDecker() {
		return decker;
	}

	public PlayerHand getPlayah() {
		return playah;
	}

	public void hitDealerUntilDone() {
		// method is pre-empted if player didn't bust || or player has blackjack
//		dealer must hit if dealer hand is 17<= || if they have blackjack
		//dealer will stop if dealer hand exceeds 21.
		
	}

//	public DealerHand getDealah() {
//		return dealah;
//	}

}
