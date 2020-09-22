package Game;

import java.util.Random;

public class DotSet {
	
	private Dot[] dots;
	
	public Dot[] getDots() {
		return dots;
	}
	
	public DotSet(int width,int height) {
		dots = new Dot[5];
		resetDots(width,height);
	}
	
	public void resetDots(int width, int height) {
		// Set the number of hit Dots to 0
		Random r = new Random();
		// Loop over all the dots
		for(int i = 0; i < dots.length; i++) {
			// Choose a random x and y position for a Dot
			float x = r.nextInt(width);
			float y = r.nextInt(height);
			// Choose the velocity of the Dot
			float vx = 10*r.nextFloat()+0.2f;
			float vy = 10*r.nextFloat()+0.2f;
			// Choose the dots direction
			if(r.nextBoolean()) {
				vx=-vx;
			}
			if(r.nextBoolean()) {
				vy=-vy;
			}
			// Choose a random size
			int size = r.nextInt(150)+50;
			// Create the dot
			dots[i] = new Dot(x,y,vx,vy,size);
		}
	}
	
	/**
	 * @param x : mouseX
	 * @param y : mouseY
	 * @return true if any of the Dots were clicked and false otherwise.
	 * 
	 */
	public boolean checkHit(int x, int y) {
		// Complete this method
		return false;
	}
	
	/** allHit
	 * 	
	 * 	This method determines if all of the Dots have been hit.
	 * 
	 * @return true if all the dots were hit and false otherwise.
	 */
	public boolean allHit() {
		// Complete this method
		return false;
	}
	
}
