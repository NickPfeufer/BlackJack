import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.*;
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
	public void drawScore(Graphics g){
		g.setFont(new Font("Serif", Font.BOLD, 20));
		g.setColor(Color.blue);
		g.drawString(hand.totalValue()+"", 15, this.offset+150);		
	}

	public void paint(Graphics g){
		int x = 50;
		drawScore(g);


		for (int i = 0; i<inHand(); i++) {
			// creats an array of rectangles to draw the cards in
			recs[i] = new Rectangle(x,this.offset, 200, 300);
			x+=100;
		}
		this.hand.paint(g, this.recs);
	}
}

