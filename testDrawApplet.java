import java.awt.*;
import java.applet.*;

public class testDrawApplet extends Applet {

	private Deck deck;
	private Card[] cards;

	public void init() {
		deck = new Deck();
		cards = deck.testDeck();
	}

	public void paint(Graphics g) {
		int count = 0;
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<13; j++) {
				cards[count].draw(g, new Rectangle((j+1)*100, (i+1)*100, 100, 150));
				count++;
			}
		}
		deck.shuffle();
		count = 0;
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<13; j++) {
				cards[count].draw(g, new Rectangle((j+1)*100, (i+5)*100, 100, 150));
				count++;
			}
		}		
	}

}