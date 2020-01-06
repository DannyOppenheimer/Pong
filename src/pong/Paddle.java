package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import engine.AbstractEntity;

public abstract class Paddle extends AbstractEntity {

	private final int WIDTH = 15, HEIGHT = 75;
	
	public Paddle(int x, int y) {
		super(x, y);
	}

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}
	
	public void collisionCheck(Ball ball) {
		if(ball.getBounds().intersects(getBounds())) {
			ball.negateX();
		}
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.white);
		g2d.fillRect(getX(), getY(), WIDTH, HEIGHT);
	}

	
}
