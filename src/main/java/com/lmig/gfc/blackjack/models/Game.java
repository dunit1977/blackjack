package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;

public class Game {

	private Deck decker;
	private PlayerHand playah;
	private DealerHand dealah;
	private Wallet wallet;
	private Bet currentBet;

	public Game() {
		super();
		this.decker = new Deck();
		this.playah = new PlayerHand();
		this.dealah = new DealerHand();
		this.wallet = new Wallet(100);
	}

	public void deal() {
		// make sure that every time you deal that you
		// refresh the players' hands.
		playah.accept(decker.draw());
		playah.accept(decker.draw());
		dealah.accept(decker.draw());
		dealah.accept(decker.draw());
	}

	public void hit() {
		playah.accept(decker.draw());
	}

	public void stand() {
		dealah.accept(decker.draw());
	}

	public Deck getDecker() {
		return decker;
	}

	public PlayerHand getPlayah() {
		return playah;
	}

	public boolean isPlayerBusted() {
		return playah.getTotal() > 21;
	}

	public boolean isPlayerBlackJack() {
		return (playah.getTotal() == 21 && playah.numberOfCards() == 2);
	}

	public boolean isPlayerTwenyOne() {
		return (playah.getTotal() == 21 && playah.numberOfCards() > 2);
	}

	public boolean isDealerBusted() {
		return dealah.getTotal() > 21;
	}

	public boolean isDealerBlackJack() {
		return (dealah.getTotal() == 21 && dealah.numberOfCards() == 2);
	}

	public boolean isDealerTwenyOne() {
		return (dealah.getTotal() == 21 && dealah.numberOfCards() > 2);
	}

	public boolean isPlayerWinner() {

		// if the dealer is busted -> true
		if (isDealerBusted() && !isPlayerBusted()) {
			return true;
		}

		// if the player has blackjack and the dealer does not have blackjack -> true
		if (!isDealerBlackJack() && isPlayerBlackJack()) {
			return true;
		}

		// if the player is not busted and has more then the dealer -> true
		if (!isPlayerBusted() && !isDealerBusted() && playah.getTotal() > dealah.getTotal()) {
			return true;
		}
		return false;
	}

	public boolean isPush() {
		return (playah.getTotal() == dealah.getTotal());
	}

	public void hitDealerUntilDone() {
		while (dealah.getTotal() <= 16 && !isPlayerBusted()) {
			dealah.accept(decker.draw());
		}
	}

	public void makePlayerBet(int bet) {
		wallet.minusBet(bet);
		currentBet = new Bet(bet);
	}

	public void makePayout() {
		if (isPlayerBlackJack() && !isDealerBlackJack()) {
			wallet.blackJackPayout(currentBet.getAmount());
		} else if (isPlayerWinner()) {
			wallet.regularwinPayout(currentBet.getAmount());
		}
	}

	public int getNumberCards() {
		return decker.countCards();
	}

	public void startNewHand() {
		playah.clearHand();
		dealah.clearHand();

	}

	public boolean isDeckEmpty() {
		if (getNumberCards() <= 5) {
			return true;
		}
		return false;

	}

	public boolean isWalletEmpty() {
		return wallet.isEmpty();
	}
}
