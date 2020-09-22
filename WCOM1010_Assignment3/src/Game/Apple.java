package Game;

import java.util.Arrays;



import java.util.Random;

public class Apple {
	private int x; // The x coordinate of the Apple
	private int y; // The y coordinate of the Apple
	private int effect; // The effect of the Apple (grow (when > 0) or shrink (when -1))
	
	// DO NOT EDIT BELOW
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getEffect() {
		return effect;
	}
	// DO NOT EDIT ABOVE
	
	/**
	 * 
	 * setEffect (2 marks)
	 * 
	 * This method should set the instance variable effect.
	 * 
	 * The effect should be set randomly.
	 * 
	 * The effect should be set to 1, 50% of the time.
	 * 
	 * The effect should be set to 2, 25% of the time.
	 * 
	 * The effect should be set to -1, 25% of the time.
	 * 
	 */
	public void setEffect() {
		// To be completed
		Random num = new Random();	
		int i = num.nextInt(100);
				if(i <= 0 && i>=50) {
					effect = 1;
				}else if (i<= 50 && i>=75) {
					effect = 2;
				}else if(i>=75 && i<=100){
					effect = -1;
				}
	}
	
	/**
	 * Apple(int,int) (3 marks)
	 * 
	 * @param w - the width of the screen
	 * @param h - the height of the screen
	 * 
	 * This constructor should select a random position for the Apple on the screen.
	 * It should also set the effect variable.
	 * 
	 * The x and y instance variables must be set to points within the borders of the game.
	 * 
	 * Imagine the game screen as a grid of 20x20 rectangles, the x and y variables should
	 * correspond to the center of those rectangles.
	 * 
	 * For example if the screen is 800x600, some possible values of x and y are:
	 * 
	 * (20,20)   (20,40)   (80,100)   (560,700)   (400,300)    (780,580)
	 * 
	 */
	public Apple(int w, int h) {
		// To be completed
		Random Xloc = new Random(w);
		x = Xloc.nextInt(w*20);
		
		Random Yloc = new Random(h);
		y = Yloc.nextInt(h*20);
	}
	
	/**
	 * DIFFICULT QUESTION (leave to the end)
	 * 
	 * Apple(int,int,Snake) (4 marks)
	 * 
	 * You will be awarded another 2 marks if you implement this constructor correctly within Game.java.
	 * 
	 * @param w - the width of the screen
	 * @param h - the height of the screen
	 * @param s - a Snake object
	 * 
	 * This constructor should select a random position on the screen for the Apple.
	 * 
	 * The Apple MUST NOT overlap the snake.
	 * 
	 * Hint: answer getFreePositions in Snake.java first.
	 * 
	 */
	public Apple(int w, int h, Snake s) {
		// To be completed
	}
	
	// DO NOT EDIT BELOW
	public boolean eat(Snake s) {
		return s.eat(this);
	}
	
}
