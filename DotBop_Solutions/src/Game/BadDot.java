package Game;

public class BadDot {
	float x,vx,size,p;
	
	// Getters
	public float getX() {
		return x;
	}
	public float getY(int width,int height) {
		// Make the BadDot move as a sin wave.
		return  Math.round(height/2 + height/2*Math.sin((4*Math.PI*x)/width+p*Math.PI));
	}
	public float getSize() {
		return size;
	}
	
	// Setters
	public void setPosition(float x) {
		this.x=x;
	}
	public void setVelocity(float vx) {
		this.vx=vx;
	}
	public void setSize(float size) {
		this.size=size;
	}

	// Constructor
	public BadDot(int width, int height) {

		int size = width/2;
		
		// Start at the left of the screen with speed 5
		float x = -size/2;
		float vx = 5;
		
		setPosition(x);
		setVelocity(vx);
		setSize(size);
	}
	
	/** move(int,int)
	 * 
	 * 	This method should move the BadDot.
	 * 
	 * 	The Dot should bounce off the left and right sides of the screen.
	 * 
	 * @param width : the width of the screen
	 * @param height : the height of the screen
	 * 
	 * Note: to make the BadDot move smoothly at the edge of the screen
	 * you may need to adjust the value of p.
	 * 
	 */
	public void move(int width, int height) {
		// Check if the BadDot reaches the left or right of the screen
		if(x-size/2>width||x<-size/2) {
			// Change the direction of the BadDot
			vx = -vx;
			// Add 1 to the phase, so that the wave continues smoothly.
			p++;
		}
		// Move the BadDot
		x+=vx;
	}
	
	/** hit(int,int,int,int)
	 * 
	 * This method determines if the BadDot was clicked.
	 * 
	 * @param x : mouseX
	 * @param y : mouseY
	 * 
	 * @return true if the dot was clicked and false otherwise.
	 * 
	 */
	public boolean hit(int x, int y, int width, int height) {
		// Get the distance in x and y between the BadDot and the mouse position
		double dx = x - this.x;
		double dy = y - getY(width,height);
		// Calculate the distance between the BadDot and the mouse position
		double dist = Math.sqrt(dx*dx+dy*dy);
		// Check if the mouse click was within the radius of the BadDot
		if(dist<=size/2) {
			return true;
		}
		return false;
	}

}
