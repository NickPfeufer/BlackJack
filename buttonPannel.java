import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class ButtonPannel extends JPanel implements ActionListener {
	private JButton draw, fold, reset, down;
	private BlackJack jack;

	public ButtonPannel(BlackJack a){
		//I tell the pannel what blackjack it is a part of so it can 
		//call functions I write in blackjack
		this.jack = a;
		setUpbuttons();
	}

	public void setUpbuttons(){
		String title = "Draw";
		draw = new JButton(title);
		draw.setActionCommand(title);
		draw.addActionListener(this);
		this.add(draw);

		title = "Stay";
		fold = new JButton(title);
		fold.setActionCommand(title);
		fold.addActionListener(this);
		this.add(fold);

		title = "New game";
		reset = new JButton(title);
		reset.setActionCommand(title);
		reset.addActionListener(this);
		this.add(reset);

		title = "Double Down";
		down = new JButton(title);
		down.setActionCommand(title);
		down.addActionListener(this);
		this.add(down);				
	}

	public void actionPerformed(ActionEvent ae){
		if ("Draw".equals(ae.getActionCommand())) {
			if (jack.totalValue() <= 21 && jack.aiCanPlay()) {
				jack.draw();
			}else if(jack.aiCanPlay()){
				jack.endTurn(false);
			}	

		}else if ("Stay".equals(ae.getActionCommand())) {
			if (jack.totalValue() <= 21 && jack.aiCanPlay()) {
				jack.endTurn(true);
			}else if (jack.aiCanPlay()) {
				jack.endTurn(false);
			}
		}else if ("New game".equals(ae.getActionCommand())) {
			jack.reset();
		}else if ("Double Down".equals(ae.getActionCommand())) {
			jack.doubleDown();
		}

	}
	
}