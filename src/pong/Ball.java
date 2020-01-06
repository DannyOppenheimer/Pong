package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import engine.AbstractEntity;

public class Ball extends AbstractEntity {

	private final int WIDTH = 32, HEIGHT = 32;
	
	private Score score1;
	private Score score2;
	
	private Timer wait;
	
	private Random randomDir;
	
	private boolean ready = false;
	
	private int velocX, velocY;
	
	public Ball(int x, int y, Score score1, Score score2) {
		super(x, y);
		randomDir = new Random();

		if(Math.round(Math.random()) == 1) {
			velocX = -6;
		} else {
			velocX = 6;
		}
		
		velocY = randomDir.nextInt(8) - 4;
		
		this.score1 = score1;
		this.score2 = score2;
		
		delayStart();
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.white);
		g2d.fillOval(getX() + (WIDTH / 2), getY() + (HEIGHT / 2), WIDTH, HEIGHT);
	}

	@Override
	public void update() {
		if(ready) {
			setX(getX() + velocX);
			setY(getY() + velocY);
			checkCollision();
		}
	}
	
	public void checkCollision() {
		if(getX() <= 0) {
			score2.setScore(score2.getScore() + 1);
			setX(380 - 16);
			setY(300 - 16);
			ready = false;
			delayStart();
		}
		if(getX() >= 780 - WIDTH) {
			
			score1.setScore(score1.getScore() + 1);
			setX(380 - 16);
			setY(300 - 16);
			ready = false;
			delayStart();
			
		}
		if(getY() <= -15) {
			velocY = -velocY;
		}
		if(getY() >= 560 - HEIGHT) {
			velocY = -velocY;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(getX() + 10, getY(), WIDTH, HEIGHT);
	}
	
	public void negateX() {
		velocX = -velocX;
		velocY = randomDir.nextInt(10) - 5;
	}

	public void delayStart() {
		
		
		
		ActionListener event = new ActionListener() {
			
			int counter = 0;
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(counter);
				
				if(counter == 3) {
					wait.stop();
					ready = true;
				}  else {
					counter++;
				}
					
			}
		};
		
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	    		wait = new Timer(500, event);
	    		wait.start();
	        }
	    });
		
	}
	
}
