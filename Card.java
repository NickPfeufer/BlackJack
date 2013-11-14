import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class Card {
	private int cardValue, x , y;
	private boolean side;
	private boolean drawn;
	private Image image;
	private String name;

	public Card(int cardValue, int x, int y, String name){
		this.cardValue = cardValue;
		this.side = false;
		this.x = x;
		this.y = y;
		this.drawn = false;
		this.name = name;
		this.image = Card.loadImage(name);
	}

	public int value(){
		return this.cardValue;
	}
	public boolean faceUp(){
		return this.side;
	}
	public boolean drawn(){
		return this.drawn;
	}

	public int x(){
		return this.x;
	}
	public int y(){
		return this.y;
	}
	public String name(){
		return this.name;
	}


	public void pull(){
		this.drawn = true;
	}
	public void push(){
		this.drawn = false;
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

	private static Image loadImage(String name){
		String path = null;
		Image image = null;

		try{
			path = "cards" + File.separator + name + ".png";
			image = ImageIO.read(new File(path));

		}catch(IOException e) {
			System.out.println("could not load image at path " + path);
			System.exit(1);
		}
		return image;
	}


	public void draw(Graphics g, Rectangle r){
		g.drawImage(this.image, r.x, r.y, r.width, r.height, null);
	}

}