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
		// Complete this method
		
		if(x > width-size/2||x<0+size/2) {
			vx = -vx;
		}
		if(y> height-size/2 || y<0+size/2) {
			vy = -vy;
		}
		if(x > width- size/2) {
			x = width - size/2;
		}
		if(x < size/2) {
			x = size/2;
		}
		
		if(y > height - size/2) {
			y = height - size/2;
		}
		if(y < size/2) {
			y = size/2;
		}
		x = x+vx;
		y = y+vy;
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
		// Complete this method
		double dx = (this.x-x);
		double dy = (this.y-y);
		double dist = Math.sqrt(dy*dy + dx*dx);
		return dist<size/2;
	}

}
