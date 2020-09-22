package Game;

public class Snake {
	private Body head; // the head of the Snake
	// The horizontal direction of the Snake
	private int dirX; // 1 (right), -1 (left) or 0
	// The vertical direction of the Snake
	private int dirY; // 1 (down), -1 (up) or 0
	
	// DO NOT EDIT BELOW
	public Body getHead() {
		return head;
	}
	public void setDir(int dirX,int dirY) {
		this.dirX=dirX;
		this.dirY=dirY;
	}
	// DO NOT EDIT ABOVE
	
	
	/**
	 * getSize (2 marks)
	 * 
	 * @return number of Body objects within the Snake
	 * 
	 */
	public int getSize() {
		// To be completed
		int n = 0;
		Body current = head;
		while (current != null) {
			n++;
			current = current.getNext();
		}
		return n;
	}
	
	/**
	 * getSnakeBody (4 marks)
	 * 
	 * This method is used to draw the Snake within Client.java.
	 * 
	 * @return an array which contains all the snake's Body objects.
	 * 
	 */
	public Body[] getSnakeBody(){
		// To be completed
		Body []b = new Body[getSize()];
		Body current = head;
		int i = 0;
		while (current != null) {
			b[i] = current;
			current = current.getNext();
			i++;
		}
		return b;
	}
	
	/**
	 * Snake(int,int) (4 marks)
	 * 
	 * @param w - the width of the screen
	 * @param h - the height of the screen
	 * 
	 * This constructor must set the head of the Snake to be
	 * a new Body object positioned in the center of the screen.
	 * 
	 * Three more Body Objects must be added below the head of the Snake
	 * 
	 * The snake's direction must also be set so that it moves upwards. (Look at setDir above)
	 * 
	 * (This is so that when the Game starts the Snake consists of 4 parts in total)
	 * 
	 * Hint: your solution should be around 6 lines long including a loop. 
	 * 
	 */
	public Snake(int w, int h) {
		// To be completed
		head = new Body(w/2, h/2);
		setDir(0,-1);
		Body current = head;
		int i = 0;
		while (current != null && i<4) {
			current.setNext(new Body(w/2,h/2+i*20));
			current = current.getNext();
			i++;
		}
	}
	
	/**
	 * move (10 marks)
	 * 
	 * This method must move the snake.
	 * 
	 * The head of the snake must move 20 pixels according to dirX and dirY.
	 * 
	 * The Body object after head must take the old co-ordinates of the head.
	 * 
	 * This process must then be repeated.
	 * 
	 * That is, the co-ordinates of the next Body object must be set to the old 
	 * co-ordinates of the previous Body object.
	 * 
	 * Hint: you only need 1 loop here.
	 */
	public void move() {
			int LeftRight=head.getX(); 
			int UpDown=head.getY();
			
			LeftRight+=20*dirX;
			UpDown+=20*dirY;
			
			Body NIGHTMARE=new Body(LeftRight,UpDown);
			NIGHTMARE.setNext(head);
			head=NIGHTMARE;
			Body current=head;
			
			while(current.getNext().getNext()!=null) {
			current=current.getNext();
			}
			current.setNext(null);
			
		}
		

	
	/**
	 * grow(int) (10 marks)
	 * 
	 * @param size - the number of Body objects to add to the snake.
	 * 
	 * This method should add Body objects to the end of the snake.
	 * 
	 * The co-ordinates of the new Body object should match the co-ordinates
	 * of the last Body object in the snake.
	 * 
	 */
	public void grow(int size) {
		// To be completed
		int LeftRight=head.getX(); 
		int UpDown=head.getY();
		
		Body NIGHTMARE = new Body(LeftRight,UpDown);
		Body current = head;
		
		while(current.getNext().getNext()!= null) {
			
					for(int i = 0; i < size;i++ ) {
						current = current.getNext();	
						current.setNext(NIGHTMARE);
						
			}
			 
		}
	}
	
	
	/**
	 * shrink (2 marks)
	 * 
	 * This method should reduce the length of the snake by 1 Body object.
	 * 
	 * The length of the snake should only be reduced if the size of the snake
	 * is greater than 3.
	 * 
	 */
	public void shrink() {
		// To be completed
		 Body current = head;
		 while(current.getNext().getNext()!=null && getSize()>=3) {
				current=current.getNext();}
				current.setNext(null);
	}

	
	/**
	 * hitSelf (4 marks)
	 * 
	 * @return true if the snake's head hits any other part of its body.
	 * 		   false otherwise.
	 */
	public boolean hitSelf() {
		// To be completed
		int x=head.getX();
		int y=head.getY();
		Body current=head.getNext();
		while(current!=null) {
			if(current.getX()==x&&current.getY()==y) {
			return true;
			}
		current=current.getNext();
		}
		return false;
	}
	
	/**
	 * hitWalls (2 marks)
	 * 
	 * @param w - the width of the screen
	 * @param h - the height of the screen
	 * 
	 * @return true if the snake's head hits or passes the edges of the screen.
	 * 		   false otherwise.
	 * 
	 */
	public boolean hitWalls(int w, int h) {
		// To be completed
		int xHead = head.getX();
		int yHead = head.getY();
		if(xHead >=w||yHead >= h) {
			return true;
		}
		return false;
	}
	
	/**
	 * eat(Apple) (4 marks)
	 * 
	 * @param a - the Apple to check collision with
	 * 
	 * This method should check to see whether the head of the snake collides
	 * with the parameter Apple.
	 * 
	 * If there is a collision then either the shrink or grow methods must be called 
	 * depending on the effect of the Apple.
	 * 
	 * @return true if the head of the snake collides with the Apple.
	 * 		   false otherwise.
	 * 
	 */
	public boolean eat(Apple a) {
		// To be completed
		int xHead = head.getX();
		int yHead = head.getY();
			if(a.getX() == xHead && a.getY() == yHead) {
				return true;
			}
		return false;
	}
	
	/**
	 * allRed(Body) (5 marks)
	 * 
	 * YOUR SOLUTION TO THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param current - A body Object which represents the current location within the Snake
	 * 
	 * This method should set every Body object from current onwards to red.
	 * 
	 * Hint: read Body.java and look at how allRed is used in Game.java (gameOver).
	 * 
	 */
	public void allRed(Body current) {
		// To be completed
		current.isRed();
		allRed(current);
	}
	
	/**
	 * DIFFICULT QUESTION (leave to the end)
	 * 
	 * getFreePositions(int,int) (10 marks)
	 * 
	 * @param w - the width of the screen
	 * @param h - the height of the screen
	 * 
	 * @return a two dimensional array which contains the co-ordinates in which the 
	 * 		   Snake is NOT located.
	 * 
	 * The first dimension must correspond to an individual set of co-ordinates.
	 * 
	 * The second dimension must correspond to the x and y co-ordinates.
	 * 
	 * Example:
	 * 
	 * int[][] coords = getFreePositions(w,h);
	 * 
	 * coords[1][0] must correspond to the x co-ordinate of the first point
	 * coords[1][1] must correspond to the y co-ordinate of the first point
	 * 
	 * coords[3][1] must correspond to the y co-ordinate of the third point
	 * 
	 */
	public int[][] getFreePositions(int w, int h) {
		// To be completed
		return null;
	}
}
