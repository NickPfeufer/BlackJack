import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	private Hand hand;
	private Rectangle[] recs = new Rectangle[12];
	private int offset;


	public Player(Deck a, int offset){
		this.hand = new Hand(a);
		this.offset = offset;
	}
	public void turn(){
		System.out.println("hahhahahah");
	}

	public int totalValue(){
		return this.hand.totalValue();
	}
	public int inHand(){
		return this.hand.inHand();
	}
	public void draw(){
		this.hand.draw();
	}
	public int offset(){
		return this.offset();
	}

	public void paint(Graphics g){
		int x = 50;


		for (int i = 0; i<inHand(); i++) {

			recs[i] = new Rectangle(x,this.offset, 200, 300);
			x+=100;
		}
		this.hand.paint(g, this.recs);
	}
}
