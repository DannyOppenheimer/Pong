package pong;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Screen;
import engine.ScreenManager;

public class GameScreen extends Screen {

	private Ball ball;
	private Player player1;
	private Player player2;
	private ScreenManager screenFactory;
	private Score score1;
	private Score score2;
	
	public GameScreen(ScreenManager screenFactory) {
		super(screenFactory);
		this.screenFactory = screenFactory;
	}

	@Override
	public void onCreate() {
		
		score1 = new Score(330, 75);
		score2 = new Score(413, 75);
		
		ball = new Ball(380 - 16, 300 - 16, score1, score2);
		
		player1 = new Player(20, 10, false);
		player2 = new Player(770, 10, true);
	
	}

	@Override
	public void onDraw(Graphics2D g2d) {
		g2d.setColor(Color.blue);
		g2d.fillRect(0, 0, 800, 600);
		g2d.setColor(Color.white);
		g2d.fillRect(390, 0, 10, 600);
		
		if(score1 != null) {
			score1.draw(g2d);
		}
		
		if(score2 != null) {
			score2.draw(g2d);
		}
		
		if(ball != null) {
			ball.draw(g2d);
		}

		if(player1 != null) {
			player1.draw(g2d);
		}
		
		if(player2 != null) {
			player2.draw(g2d);
		}
		
		
	}

	@Override
	public void onUpdate() {
		
		ball.update();
		player1.update(ball, screenFactory.getCurrentScreen());
		player2.update(ball, screenFactory.getCurrentScreen());
		
		if(score1.getScore() >= 5) {
			screenFactory.showScreen(new EndScreen(screenFactory, 1));
		}
		if(score2.getScore() >= 5) {
			screenFactory.showScreen(new EndScreen(screenFactory, 2));
		}
		
	}

}
