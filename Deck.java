import java.util.Random;

class Deck {
	private Card[] cards = new Card[52];
	private Random r = new Random();

	public Deck(){
		int count = 0;
		String name;
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<13; j++) {

				name = findName(i, j);


				if (j >= 9) {
					cards[count] = new Card(10,0,0, name);
				}else if (j>=1) {
					cards[count] = new Card(j+1,0,0, name);
				}else{
					cards[count] = new Card(11,0,0, name);
				}
				count++;

			}
		}
	}

	private String findName(int i, int j){
		String suit;
		if (i == 0) {
			suit = "Hearts";
		}else if (i == 1) {
			suit = "Spades";
		}else if (i == 2) {
			suit = "Clubs";
		}else{
			suit = "Diamonds";
		}

		if (j == 0) {
			return "A" + suit;
		}else if (j == 10) {
			return "J" + suit;
		}else if (j == 11) {
			return "Q" + suit;
		}else if (j == 12) {
			return "K" + suit;
		}else{
			j++;
			return j + suit;
		}

	}

	public Card[] testDeck(){
		return cards;
	}



	public Card draw(){
		for (int i = 0; i<52 ; i++) {
			if (!cards[i].drawn()) {
				cards[i].pull();
				return cards[i];
			}
		}
		return null;
	}

	public void shuffle(){
		for (int j = 0; j<52; j++) {
			cards[j].push();
		}


		Card temp;
		int j;
		for (int i = 51; i>=0; i--) {
			j = r.nextInt(i+1);
			temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp;
		}
	}

	public void printValue(){
		for (int i = 0; i<52; i++) {
			System.out.println( cards[i].value() + cards[i].name());
		}
	}


	public static void main(String[] args) {
		Deck bob = new Deck();
		bob.printValue();
		bob.shuffle();
		bob.printValue();
	}


}