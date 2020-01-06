package pong;

import engine.Game;

public class Main {
	
	private Game game;
	
	public Main() {
		
		//create our game window and main screen.
		game = new Game(800, 600, "Pong", 10);
		game.getScreenFactory().showScreen(new MainScreen(game.getScreenFactory()));
		
	}
	
	public static void main(String[] args) {
		
		// just to get out of static context.
		new Main();
		
	}
}
