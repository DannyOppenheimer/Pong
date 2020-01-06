package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import engine.Screen;
import engine.ScreenManager;

public class EndScreen extends Screen {

	int pWon;
	
	public EndScreen(ScreenManager screenFactory, int pWon) {
		super(screenFactory);
		this.pWon = pWon;
	}

	@Override
	public void onCreate() {
		
	}

	@Override
	public void onDraw(Graphics2D g2d) {
		g2d.setColor(Color.red);
		g2d.fillRect(0, 0, 800, 600);
		g2d.setColor(Color.black);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 100)); 
		if(pWon == 1) {
			g2d.drawString("Player 1 Wins!", 100, 250);
		} else {
			g2d.drawString("Player 1 Wins!", 100, 250);
		}
	}

	@Override
	public void onUpdate() {
		
	}
	
}
