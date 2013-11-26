import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class Dealer extends Player {
// I noticed that I would be writing a lot of code more than once, so I extended player

	private boolean play = false;
	private Image image;
	private int offset;

	public Dealer(Deck a, int x){
		super(a, x);
		this.offset = x;
		this.image = Dealer.loadImage();
	}
	public void turn(){
		play = true;
	}
	public void paint(Graphics g){
		if (this.play) {
			super.paint(g);
		}else {
			super.paint(g);
			g.drawImage(this.image, 150, this.offset, 200, 300, null);
		}
	}
	public void drawScore(Graphics g){
		//only draws score if the AI has gone
		if (this.play) {
			super.drawScore(g);
		}
	}

	private static Image loadImage(){
		String path = null;
		Image image = null;

		try{
			path = "cards" + File.separator + "back-blue" + ".png";
			image = ImageIO.read(new File(path));

		}catch(IOException e) {
			System.out.println("could not load image at path " + path);
			System.exit(1);
		}
		return image;
	}
}