import java.awt.*;
import java.applet.*;

class BlackJack extends Applet {
	private Deck deck;
	private Hand player;
	private Hand ai;
	private Card[] cards;

	public void init() {
		this.deck = new Deck();
		this.player = new Hand(deck);
		this.ai = new Hand(deck);

		
	}

	public boolean playersTurn(){

		if (this.player.totalValue() <= 21) {
			//check for draw
			//this.player.draw();
			//else check for fold
			//return true;
		}
		return false;
	}

	public void paint(Graphics g) {
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