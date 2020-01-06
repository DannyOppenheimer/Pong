package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import engine.Screen;
import engine.ScreenManager;

public class MainScreen extends Screen {

	public MainScreen(ScreenManager screenFactory) {
		super(screenFactory);
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
		g2d.drawString("Press enter to begin!", 3, 300);
	}

	@Override
	public void onUpdate() {
		
		if(getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_ENTER)) {
			getScreenFactory().showScreen(new GameScreen(getScreenFactory()));
		}
	}

	
}
