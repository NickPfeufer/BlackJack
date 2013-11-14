import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hand {
	private Card[] cards = new Card[12];
	private Deck deck;
	private int inHand;

	public Hand(Deck a){
		this.deck = a;
		this.inHand = 0;
		//deck.shuffle();
		for (int i = 0; i<2; i++) {
			this.draw();
		}
	}

	public int inHand(){
		return this.inHand;
	}

	public void draw(){
		this.cards[this.inHand] = this.deck.draw();
		this.inHand++;
	}

	public void printValue(){
		for (int i = 0; i<this.inHand(); i++) {
			System.out.println(this.cards[i].value());
		}
	}

	public int totalValue(){
		int temp = 0;
		for (int i = 0 ; i<this.inHand; i++) {
			temp+=cards[i].value();
		}
		
		for (int i = 0 ; i<this.inHand; i++) {
			if (cards[i].value() == 11 && temp > 21) {
				temp -= 10;
			} 
		}
		return temp;		
	}

	public boolean broke(){
		if (this.totalValue() > 21) {
			return true;
		//	int currentCalc = this.totalValue();
		//	
		}
		return false;
	}

	public void paint(Graphics g, Rectangle[] r){
		for (int i = 0 ; i<this.inHand; i++) {
			cards[i].draw(g, r[i]);
		}
	}


	public static void main(String[] args) {
		Deck a = new Deck();
		Hand b = new Hand(a);
		b.printValue();
	}

}