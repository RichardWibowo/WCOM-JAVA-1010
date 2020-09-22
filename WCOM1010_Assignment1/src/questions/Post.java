package questions;

import java.util.Random;

public class Post {
	int postId;
	User poster;
	String message;
	
	public int getId() {
		return postId;
	}
	
	public User getPoster() {
		return poster;
	}
	
	public String getMessage() {
		return message;
	}
	
	/**
	 * 
	 * 2 marks
	 * 
	 * @param p
	 * 
	 * This method should set the instance variable poster to
	 * the parameter object p.
	 * 
	 * Note that the User.java equals method must be correct for you to gain
	 * marks here.
	 * 
	 * Hint: "this"
	 * 
	 */
	public void setPoster(User poster) {
		// To be completed
		this.poster = poster;
	}
	
	/**
	 * 
	 * 5 marks 
	 * 
	 * @param msg
	 * 
	 * This method should set the instance variable message
	 * to the parameter variable msg subject to the below conditions:
	 * 
	 * If the length of the parameter variable msg is less than 1 
	 * the message should be set to "-".
	 * 
	 * If the parameter variable msg is longer than 50 characters, the instance 
	 * variable message should only contain the first 50 characters of msg.
	 * 
	 */
	public void setMessage(String msg) {
		// To be completed
		if(msg.length() < 1) {
			msg = "-";
		}else if (msg.length()>50) {
			msg = msg.substring(0, 50);
		}message = msg;
	}
	
	/**
	 * 
	 * 5 marks 
	 * 
	 * Constructor
	 * 
	 * @param poster
	 * @param message
	 * 
	 * This constructor should set the instance variables to the corresponding
	 * parameter variables.
	 * 
	 * You must use the above setters to complete this method. You will not 
	 * be awarded marks if the above setters are not used.
	 * 
	 * The constructor should set the instance variable postId to a random
	 * number between 1000 and 9999.
	 * 
	 * Note that the setUser and setMessage methods must be correct to gain
	 * marks for this question
	 * 
	 */
	public Post(User poster, String message) {
		// To be completed
		
		this.postId = new Random().nextInt(9000) + 1000; 
		setPoster(poster);
		setMessage(message);
	}
	
	
	/**
	 * DO NOT EDIT THE BELOW CODE
	 */
	public Post() {}
	public String toString() {
		return poster.getUsername()+": "+message;
	}
}
