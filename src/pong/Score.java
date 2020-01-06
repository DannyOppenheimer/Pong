package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import engine.AbstractEntity;

public class Score extends AbstractEntity {

	private int score = 0;
	
	private int x, y;
	
	public Score(int x, int y) {
		super(x, y);
		this.x = x;
		this.y = y;

	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 100)); 
		g2d.setColor(Color.white);
		g2d.drawString(Integer.toString(this.score), this.x, this.y);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int s) {
		this.score = s;
	}

}
