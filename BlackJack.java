import java.awt.*;
import java.applet.*;

import java.awt.event.*;
import javax.swing.*;


public class BlackJack extends Applet {
	private Deck deck;
	private Card[] cards;

	private Player player;
	private Player ai;
	private boolean aiCanPlay;


	private int outcome;
	private ButtonPannel pannel;
	private BettingPannel betpannel;

	private int bet, chips;
	private boolean betting = true;


	public void init() {
		this.deck = new Deck();
		//-test-

		chips = 100;
		bet = 1;
		//-test-
		betplay();


		
	}
	public void doubleDown(){
		aiCanPlay = false;
		this.ai.turn();
		bet *= 2;
		draw();
		if (this.player.totalValue() > 21) {
			endTurn(false);
		}else{
			endTurn(true);
		}
	}

	public boolean aiCanPlay(){
		return this.aiCanPlay;
	}
	public int totalValue(){
		return this.player.totalValue();
	}
	public void reset(){
		this.remove(this.pannel);
		betplay();
	}

	public void betplay(){
		this.betpannel = new BettingPannel(this);
		this.add(this.betpannel);
		betting = true;
		bet = 1;
		chips--;
		validate();
		repaint();
	}

	public void betMore(){
		if (chips > 0) {
			bet++;
			chips--;
			repaint();
		}
	}
	public void betLess(){
		if (bet > 1) {
			bet--;
			chips++;
			repaint();
		}
	}



	public void play(){
		if (chips == -1) {
			chips = 100;
			this.remove(this.betpannel);
			reset();
		}else{
			this.remove(this.betpannel);			
			betting = false;
		//-test-

			this.pannel = new ButtonPannel(this);
			this.add(this.pannel);		
		//-test-
			this.aiCanPlay = true;
			this.outcome = 3;
			this.deck.shuffle();
			this.player = new Player(deck, 50);
			this.ai = new Dealer(deck, 450);
			System.out.println("initilized");
			validate();
			repaint();			
		}

	}
	public void endTurn(boolean p){
		boolean a = aiTurn();
		repaint();		
		if (p && a) {
			this.outcome = victory();	
		}else if (p) {
			this.outcome = 0;
		}else if (a) {
			this.outcome = 1;
		}else{
			this.outcome = 2;
		}		
	}

	//public boolean playersTurn(){
	//	repaint();
	//	while(this.player.totalValue() <= 21) {
			//check for draw
	//		if (playersChoice == 1) {
	//			this.player.draw();
			//	repaint();
			//	playersChoice = 0;		
	//		}else if (playersChoice == 2) {
			//	playersChoice = 0;
			//	repaint();
			//	return true;
	//		}
	//	}
	//	playersChoice = 0;
	//	return false;
	//}
	public boolean aiTurn(){
		if(aiCanPlay){
			aiCanPlay = false;
			this.ai.turn();
			while (this.ai.totalValue()<17) {
				this.ai.draw();
				repaint();			
			}	
		}

		if (this.ai.totalValue()<=21) {
			return true;
		}else {
			return false;
		}


		
	}

	public int victory(){
		if ((21 - this.ai.totalValue()) > (21 - this.player.totalValue())) {
			return 0;
		}else if ((21 - this.ai.totalValue()) < (21 - this.player.totalValue())) {
			return 1;
		}else {
			if (this.ai.totalValue() == 21 && this.player.totalValue() == 21) {
				if (this.ai.inHand() == 2 && this.player.inHand() > 2) {
					return 1;
				}else if (this.ai.inHand() > 2 && this.player.inHand() == 2) {
					return 0;
				}else {
					return 2;
				}
			}
			return 2;
		}


	}
	public String victoryString(){
		if (this.outcome == 0) {
			chips += 2*bet;	
			bet = 0;
			return "Victory";

		}else if (this.outcome == 1) {
			bet = 0;
			return "Loss";
		}else if (this.outcome == 2) {
			chips += bet;
			bet = 0;
			return "Draw";
		}else{
			return "";
		}
	}

	public void draw(){
		this.player.draw();
		repaint();
		if (aiCanPlay && this.player.totalValue() > 21) {
			endTurn(false);
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 1000, 1000);		
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.setColor(Color.red);
		if (betting) {
			if (chips == -1) {
				System.out.println("too few chips");
				g.drawString("You are out of chips, press play to continue", 100, 400);
			}else{
				System.out.println("draw strings");
				g.drawString("You have "+chips+" chips left in the pot", 50, 300);
				g.drawString("You are betting "+bet+" chip(s). You must bet at least one.", 50, 500);
			}
		}else{
			this.player.paint(g);
			this.ai.paint(g);


			g.setColor(Color.blue);
			g.drawString(victoryString(), 100, 400);							
		}
		super.paint(g);


		
		
	}
} 