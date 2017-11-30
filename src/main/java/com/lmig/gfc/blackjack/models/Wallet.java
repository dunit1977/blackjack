package com.lmig.gfc.blackjack.models;

public class Wallet {

	private int wallet; 
	
	public Wallet(int wallet) {
	this.wallet = wallet;
	}
	
	public boolean isEmpty() {
		if(wallet == 0) {
			return true;
		}
		return false;
	}
	
//	public int updateWallet(int bet, int wallet, String gameisOver) {
//		/if player win = Blackjack then Wallet + (bet * 1.5) = new Wallet
//		/if player win = Regular then Wallet + (bet * 1.0)  = new Wallet
//		/if player lose = Blackjack then Wallet - (bet * 1.5) = new Wallet
//		/if player lose = Regular then Wallet - (bet * 1.0) = new Wallet
		
//	}
	
	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	
}

