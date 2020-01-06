package pong;

import java.awt.event.KeyEvent;

import engine.Screen;

public class Player extends Paddle {

	private boolean isPlayer1;
	
	public Player(int x, int y, boolean p) {
		super(x, y);
		isPlayer1 = p;
	}

	
	public void update(Ball ball, Screen screen) {
		if(isPlayer1) {
			if(screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_UP)) {
				setY(getY() - 5);
			}
			
			if(screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_DOWN)) {
				setY(getY() + 5);
			}
		} else {
			if(screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_W)) {
				setY(getY() - 5);
			}
			
			if(screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_S)) {
				setY(getY() + 5);
			}
		}

		collisionCheck(ball);
		edgeCheck();
	}


	@Override
	public void update() {
		
	}
	
	public void edgeCheck() {
		if(getY() <= 0) {
			setY(3);
		}
		
		if(getY() >= 575 - 75) {
			setY(572 - 75);
		}
	}

}