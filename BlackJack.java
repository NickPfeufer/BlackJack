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



	public void init() {
		this.deck = new Deck();
		this.pannel = new ButtonPannel(this);
		play();


		
	}

	public boolean aiCanPlay(){
		return this.aiCanPlay;
	}
	public int totalValue(){
		return this.player.totalValue();
	}




	public void play(){
		this.aiCanPlay = true;
		this.outcome = 3;
		this.deck.shuffle();
		this.player = new Player(deck, 50);
		this.ai = new Dealer(deck, 450);
		System.out.println("initilized");
		repaint();
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
		aiCanPlay = false;
		this.ai.turn();
		while (this.ai.totalValue()<17) {
			this.ai.draw();
			repaint();			
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
			return "Victory";
		}else if (this.outcome == 1) {
			return "Loss";
		}else if (this.outcome == 2) {
			return "Draw";
		}else{
			return "";
		}
	}

	public void draw(){
		this.player.draw();
	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 4000, 3000);
		this.player.paint(g);
		this.ai.paint(g);

		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.setColor(Color.blue);
		g.drawString(victoryString(), 100, 400);
	//	int count = 0;
	//	for (int i = 0; i<4; i++) {
	//		for (int j = 0; j<13; j++) {
	//			cards[count].draw(g, new Rectangle((j+1)*100, (i+1)*100, 50, 75));
	//			count++;
	//		}
	//	}
	//	deck.shuffle();
	//	count = 0;
	//	for (int i = 0; i<4; i++) {
	//		for (int j = 0; j<13; j++) {
	//			cards[count].draw(g, new Rectangle((j+1)*100, (i+5)*100, 50, 75));
	//			count++;
	//		}
	//	}		
	}
} 