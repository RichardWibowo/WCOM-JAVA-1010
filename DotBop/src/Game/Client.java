package Game;

import processing.core.*; 

public class Client extends PApplet {
	
	Game game;
	
	public void setup() {
		background(226,240,217);
		game = new Game(width,height);
	}

	public void draw() {
		background(200);
		
		// Check if the game is over or not
		if(game.isGameOver()) {
			fill(255,0,0);
			text("Game Over!",width/2,height/2);
		}else {	
			fill(169,209,142);
			stroke(84,130,53);
			strokeWeight(5);
			// Get all the dots from the Game
			Dot[] dots = game.getDotSet().getDots();
			// Loop over all dots and move them
			for(int i = 0; i<dots.length;i++) {
				Dot d = dots[i];
				// Move the dot
				d.move(width,height);
				// Draw the dot
				if(!d.getHit()) {
					ellipse(d.getX(),d.getY(),d.getSize(),d.getSize());
				}
			}
	
			// Draw and move the bad dot
			fill(240,112,112);
			stroke(155,29,29);
			BadDot b = game.getBadDot();
			b.move(width, height);
			ellipse(b.getX(),b.getY(width,height),b.getSize(),b.getSize());
		}
		// Draw the score
		fill(0);
		text("Score: "+game.getScore(),width/2,20);
		
	}
	
	public void mousePressed() {
		// Check if game over and reset
		if(game.isGameOver()) {
			game = new Game(width,height);
		}
		
		// Check if the BadDot was clicked
		if(game.getBadDot().hit(mouseX, mouseY, width, height)) {
			// Game over
			game.gameOver();
			return;
		}
		
		// Check if any of the dots were hit
		game.click(mouseX, mouseY);
	}
	
	public void keyPressed() {
		
	}
	
	public void settings() {  
		// Enter your screen size below
		size(800, 600); 
	}
	
	public static void main(String[] args) {
		PApplet.main("Game.Client"); // The "Game.Client" should match your project
	}
}
