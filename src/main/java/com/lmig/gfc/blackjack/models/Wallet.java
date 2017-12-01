package com.lmig.gfc.blackjack.models;

public class Wallet {

	private int dollars; 
	
	public Wallet(int wallet) {
		this.dollars = wallet;
	}
	
	public boolean isEmpty() {
		if(dollars == 0) {
			return true;
		}
		return false;
	}

	public int getDollars() {
		return dollars;
	}

	public void minusBet(int bet) {
		dollars = dollars - bet;
	}
	
	public void blackJackPayout (int bet) {
		Double amountToAdd = bet * 2.5;
		dollars = dollars + amountToAdd.intValue();
	}
	
	public void regularwinPayout (int bet) {
		dollars = dollars + (bet * 2);
	}
	
//	public int updateWallet(int bet, int wallet, String gameisOver) {
//		/if player win = Blackjack then Wallet + (bet * 1.5) = new Wallet
//		/if player win = Regular then Wallet + (bet * 1.0)  = new Wallet
//		/if player lose = Blackjack then Wallet - (bet * 1.5) = new Wallet
//		/if player lose = Regular then Wallet - (bet * 1.0) = new Wallet
		
//	}
	

	
}

