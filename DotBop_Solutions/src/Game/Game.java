package Game;

public class Game {
	BadDot badDot;
	DotSet dotSet;
	int score,width,height;
	boolean gameOver;
	
	public BadDot getBadDot() {
		return badDot;
	}
	public DotSet getDotSet() {
		return dotSet;
	}
	public int getScore() {
		return score;
	}
	public boolean isGameOver() {
		return gameOver;
	}

	public Game(int width, int height) {
		score = 0;
		dotSet = new DotSet(width,height);
		badDot = new BadDot(width,height);
		this.width=width;
		this.height=height;
	}
	
	public void click(int x, int y) {
		// Determine if any dots were hit, and store result in hit variable
		boolean hit = dotSet.checkHit(x, y);
		// If a dot is hit, the score increases by 1
		if(hit) {
			score++;
		}
		// Check if all dots are hit and if so reset them
		if(dotSet.allHit()) {
			dotSet.resetDots(width, height);
		}
	}
	
	public void gameOver() {
		gameOver=true;
	}

}
