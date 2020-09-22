
package Game;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Game {

	private ArrayList<Apple> apples;
	private ArrayList<Score> scores;
	private int score;
	private Snake s;
	private int page;
	
	// DO NOT EDIT BELOW
	public Snake getSnake() {
		return s;
	}

	public ArrayList<Apple> getApples() {
		return apples;
	}

	public ArrayList<Score> getScores() {
		return scores;
	}

	public int getCurrScore() {
		return score;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	// DO NOT EDIT ABOVE
	
	/**
	 * Game(int,int) (2 marks)
	 * 
	 * @param width - the width of the screen
	 * @param height - the height of the screen
	 * 
	 * This constructor should call the startGame method
	 * and store a new ArrayList of Score objects into the
	 * instance variable scores.
	 * 
	 */
	public Game(int width, int height) {
		// To be completed
		startGame(width,height);
		scores = new ArrayList<Score>();
	}

	/**
	 * startGame(int,int) (3 marks)
	 * 
	 * @param width - the width of the screen
	 * @param height - the height of the screen
	 * 
	 * This method will run whenever a new game starts.
	 * 
	 * It should:
	 * 		Create a new Snake object and store it in the instance variable s.
	 * 		Create a new ArrayList of Apple objects and store it in the instance variable apples.
	 * 		Add an Apple to the ArrayList apples.
	 * 		Set the instance variable score to 0.
	 * 		Set the page to 0.
	 * 
	 * Hint: your answer should only be 5 lines long.
	 */
	public void startGame(int width, int height) {
		// To be completed
		s = new Snake(300,400);
		apples = new ArrayList<Apple>();
		apples.add(new Apple(800/20,600/20));
		score = 0;
		page = 0;
		
	}

	/**
	 * step(int,int) (10 marks)
	 * 
	 * @param width - the width of the screen
	 * @param height - the height of the screen
	 * 
	 * This method will be executed every frame.
	 * 
	 * The method should:
	 * 
	 * 		Move the snake
	 * 		Call the gameOver method if the snake hits itself or the walls
	 * 		Check if the Snake has eaten any Apples
	 * 		If the Snake ate an Apple then:
	 * 			The score should increase by 1
	 * 			The Apple should be reset
	 * 			Add a Apple object to apples if the score is a multiple of 5
	 * 
	 * Hint: complete move, hitSelf, hitWalls and eat in Snake.java first.
	 * 
	 */
	public void step(int w, int h) {
		// To be completed
		s.move();
		if(s.hitSelf()==true||s.hitWalls(w, h)==true) {
			gameOver();
			
		}
		if(s.eat(apples.get(0))) {
			score ++;
			apples.removeAll(apples);
			if(score %5 == 0) {
				apples.add(new Apple(800/20,600/20));	
			}
			
		}
	}

	/**
	 * sortScores(boolean) (5 marks)
	 * 
	 * @param asc - whether to sort in ascending or descending order.
	 * 
	 * This method should sort all the Score objects in scores in either
	 * ascending or descending order.
	 * 
	 * When the parameter variable asc is true, it should sort in ascending order.
	 * 
	 * When the parameter variable asc is false, it should sort in descending order.
	 * 
	 */
	public void sortScores(boolean asc) {
		// To be completed
		if(asc==true) {
			Collections.sort(scores);
		}else if(asc != true) {
			Collections.sort(scores,Collections.reverseOrder());
		}
	}
	
	// DO NOT EDIT BELOW
	public void gameOver() {
		page = 2; // Move to Game Over screen
		s.allRed(s.getHead()); // Make the snake red
	}
	public void addScore(String name) {
		scores.add(new Score(name, score)); // Add the new score to scores
		sortScores(false); // Sort the scores in descending order
	}

}
