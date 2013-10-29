class Card {
	private int cardValue, x , y;
	private boolean side;
	private boolean drawn;
	//variables for image

	public Card(int cardValue, int x, int y){
		this.cardValue = cardValue;
		this.side = false;
		this.x = x;
		this.y = y;
		this.drawn = false;
	}

	public int value(){
		return this.cardValue;
	}
	public boolean faceUp(){
		return this.side;
	}
	public int x(){
		return this.x;
	}
	public int y(){
		return this.y;
	}


	public void draw(){
		this.drawn = true;
	}
	public void flip(){
		side = !side;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}


	public void draw(){
		//draw face up side
	}

}