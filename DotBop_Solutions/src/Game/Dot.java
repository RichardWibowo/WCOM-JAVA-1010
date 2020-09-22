package Game;

public class Dot {
	float x,y,vx,vy,size;
	boolean hit;
	
	// Getters
	public boolean getHit() {
		return hit;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public float getSize() {
		return size;
	}
	
	// Setters
	public void setPosition(float x, float y) {
		this.x=x;
		this.y=y;
	}
	public void setVelocity(float vx, float vy) {
		this.vx=vx;
		this.vy=vy;
	}
	public void setSize(float size) {
		this.size=size;
	}

	public Dot(float x, float y, float vx, float vy, float size) {
		setPosition(x,y);
		setVelocity(vx,vy);
		setSize(size);
		hit=false;
	}
	
	/** move(int,int)
	 * 
	 * 	This method should move the Dot.
	 * 
	 * 	The Dot should bounce off the sides of the screen.
	 * 
	 * @param width : the width of the screen
	 * @param height : the height of the screen
	 * 
	 */
	public void move(int width, int height) {
		// Check right side of the screen
		if(x>width - size/2) {
			vx = -vx;
			x = width - size/2;
		}
		// Check left side of the screen
		if(x < size/2) {
			vx = -vx;
			x = size/2;
		}
		// Check the bottom of the screen
		if(y>height - size/2) {
			vy=-vy;
			y=height-size/2;
		}
		// Check the top of the screen
		if(y <= size/2) {
			vy=-vy;
			y=size/2;
		}
		// Move the dot
		x+=vx;
		y+=vy;
	}
	
	/** hit(int,int)
	 * 
	 * This method determines if the Dot was clicked.
	 * 
	 * @param x : mouseX
	 * @param y : mouseY
	 * 
	 * @return true if the dot was clicked and false otherwise.
	 * 
	 */
	public boolean hit(int x, int y) {
		// Get the distance in x and y between the Dot and the mouse position
		double dx = x - this.x;
		double dy = y - this.y;
		// Calculate the distance between the Dot and the mouse position
		double dist = Math.sqrt(dx*dx+dy*dy);
		// Check if the mouse click was within the radius of the BadDot
		// This should only return true if the Dot hasn't been hit yet.
		if(!hit&&dist<=size/2) {
			hit=true;
			return true;
		}
		return false;
	}

}
