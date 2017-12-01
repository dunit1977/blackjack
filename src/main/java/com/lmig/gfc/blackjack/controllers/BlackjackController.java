package com.lmig.gfc.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjack.models.AceCard;
import com.lmig.gfc.blackjack.models.DealerHand;
import com.lmig.gfc.blackjack.models.Game;
import com.lmig.gfc.blackjack.models.PlayerHand;
import com.lmig.gfc.blackjack.models.NumberCard;
import com.lmig.gfc.blackjack.models.Suits;
import com.lmig.gfc.blackjack.models.Wallet;

@Controller
public class BlackjackController {

	
	public BlackjackController() {
		game = new Game();
	}

	 private Game game;
	 

	@GetMapping("/")
	public ModelAndView showBetScreen() {
		ModelAndView mv = new ModelAndView();
		mv.addObject( "game", game);
		mv.setViewName("blackjackui");

		return mv;
	}

	@PostMapping("/bet")
	public ModelAndView handleBet(int bet) {
		game.makePlayerBet(bet);
		game.startNewHand();
		game.deal();
		

		ModelAndView mv = new ModelAndView();
		if (game.isPlayerBlackJack() || game.isDealerBlackJack()) {
			mv.setViewName("redirect:/over");
		} else {
			mv.setViewName("redirect:/play");
		}
		return mv;
	}

	@GetMapping("/play")
	public ModelAndView showPlayScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");
		mv.addObject("game", game);

		return mv;
	}

	@GetMapping("/summary")
	public ModelAndView showSummary() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("summary");
		mv.addObject("game", game);

		return mv;
	}

	@PostMapping("/hit")
	public ModelAndView playerHit() {
		game.hit();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/play");
		mv.addObject(game);
		return mv;
	}
	
	@PostMapping("/stand")
	public ModelAndView playerStand() {
		game.hitDealerUntilDone();
		game.makePayout();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/summary");
		mv.addObject(game);
		return mv;
	}
	
}

