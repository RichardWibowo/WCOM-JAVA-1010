package questions;

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
	 * 
	 * @param p
	 * 
	 * This method should set the instance variable poster to
	 * the parameter object p.
	 * 
	 * 
	 */
	public void setPoster(User poster) {
		// To be completed
		this.poster=poster;
	}
	
	/**
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
		if(msg.length()<1) {
			msg = "-";
		}
		if(msg.length()>50) {
			msg = msg.substring(0,50);
		}
		message = msg;
	}
	
	/**
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
	 * 
	 */
	public Post(User poster, String message, int postId) {
		// To be completed
		setMessage(message);
		setPoster(poster);
		this.postId=postId;
	}

	public Post() {}
	public String toString() {
		return poster.getUsername()+": "+message;
	}
}
