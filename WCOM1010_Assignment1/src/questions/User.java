package questions;

public class User {
	
	private String username;
	private String password;
	private String email;
	private boolean turbo;
	
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public boolean isTurbo() {
		return turbo;
	}
	
	/**
	 * 
	 * 2 marks
	 * 
	 * @param t - the turbo to set
	 * 
	 * This method should set the instance variable turbo to the
	 * parameter variable t.
	 * 
	 */
	public void setTurbo(boolean t) {
		turbo = t;
	}
	
	/**
	 * 
	 * 4 marks
	 * 
	 * @param u - the username to set
	 * 
	 * Set the instance variable username to the parameter 
	 * variable u based on the below conditions:
	 * 
	 * The username should always start with an upper-case character
	 * 
	 * If the length of the parameter String u is less than 1 then 
	 * username should be set to "Discordian"
	 * 
	 */
	public void setUsername(String u) {
		// To be completed
		if(u.length()<1) {
			u = "Discordian";
		}this.username = u.substring(0, 1).toUpperCase() + u.substring(1);
	}
	
	/**
	 * 
	 * 4 marks
	 * 
	 * @param p - the password to set
	 * 
	 * Set the instance variable password to the parameter 
	 * variable p based on the below condition:
	 * 
	 * The password must contain at least one upper-case and lower-case character.
	 * If the parameter variable p does not contain at least one upper-case character
	 * and at least one lower-case character the string "!1!" should be added to the 
	 * end of the password.
	 * 
	 * For example:
	 * 
	 * 	setPassword("Weakpassword") should set password = "Weakpassword"
	 * 
	 * 	setPassword("nocapitals") should set password = "nocapitals!1!"
	 * 
	 */
	@SuppressWarnings("unused")
	public void setPassword(String p) {
		// To be completed
		boolean hasCap = false, hasLow = false;char c;
	for(int r = 0;r<p.length();r++) {
		c = p.charAt(r);
			if(Character.isUpperCase(c)) {
				hasCap = true;
			}else if(Character.isLowerCase(c)) {
				hasLow = true;
			}if(hasCap == true && hasLow == true) {
				password= p;
			} else if(p==null){
				password = "!1!";
			}else {
				password = p.concat("!1!");
			}
		}
	}
	/**
	 * 
	 * 4 marks
	 * 
	 * @param e - the email to set
	 * 
	 * Set the instance variable email to the parameter 
	 * variable e based on the below conditions:
	 * 
	 * All characters should be lower case.
	 * 
	 * If the parameter String e is not a valid email address, the instance variable
	 * email should be set to "discordian@discord.com".
	 * 
	 * (Note it is up to you to determine how to check if an email address is valid, it doesn't
	 * have to be complicated, it just needs to pass the JUnit test)
	 * 
	 * For example:
	 * 
	 * 	setEmail("wrong.com") should set email = "discordian@discord.com"
	 * 
	 * 	setEmail("good@email.com") should set email = "good@email.com"
	 * 
	 *  setEmail("CApital@MQ.edu.AU") should set email = "capital@mq.edu.au"
	 * 
	 */
	public void setEmail(String e) {
		// To be completed
		//StringBuffer newStr=new StringBuffer(e);
		if(!e.contains("@")) {
			e = "discordian@discord.com";
		}
		email = e.toLowerCase();
	}
	
	/**
	 * 
	 * 2 marks
	 * 
	 * Constructor
	 * 
	 * @param username
	 * @param email
	 * @param password
	 * @param turbo
	 * 
	 * This constructor should set the instance variables to the corresponding
	 * parameter variables.
	 * 
	 * You must use the above setters to complete this method. You will not 
	 * be awarded marks if the above setters are not used.
	 * 
	 * Note: the test file for this method only considers valid passwords. If you are
	 * having trouble completing setPassword you can still attain full marks here if
	 * you program setPassword to set the password without validation.
	 * 
	 */
	public User(String username, String email, String password, boolean turbo) {
		setUsername(username);
		setEmail(email);
		setPassword(password);
		setTurbo(turbo);
	}
	
	/**
	 * 
	 * 2 marks
	 * 
	 * This method should compare the calling User object to
	 * the parameter User object u.
	 * 
	 * Note that your setters and constructor must be correct to gain marks in this question
	 * 
	 * @param u - the User object to compare
	 * 
	 * @return true if the parameter User object u has the same
	 * username, password, email and turbo as the calling object.
	 * Return false otherwise.
	 * 
	 * Hint: Use the checkPassword method, scroll to the bottom of User.java to find it
	 * 
	 */
	public boolean equals(User u) {
		// To be completed
		if(this.turbo == u.turbo &&
			this.email.equals(u.email)&&
			this.password.equals(u.password)&&
			this.username.equals(u.username)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * 2 marks
	 * 
	 * Note that your setters and constructor must be correct to gain marks in this question
	 * 
	 * @return the calling User objects username, email and turbo.
	 * 
	 *  For example if the calling object has username = "KennyS", 
	 *  email="kennys@gamers.com", turbo = true, the toString method should
	 *  return "Username: KennyS, Email: kennys@gamers.com, turbo: true"
	 *  
	 *  (Don't forget to include the spaces, commas and colons)
	 *  
	 */
	public String toString() {
		// To be completed
		return "Username: " + username+"," + " Email: "+ email+","+ " turbo: " +  turbo;
	}
	
	/**
	 * DO NOT EDIT THE BELOW CODE
	 */
	public User() {}
	/**
	 * 
	 * You may notice there is not getter for the password.
	 * 
	 * This was deliberate as we should limit access to the password variable.
	 * 
	 * Instead, we can create a method to verify whether or a string matches the password.
	 * 
	 * Similar to when you login to a website, you provide your password and the system checks
	 * whether or not your password matches the one they have stored from when you registered.
	 * 
	 * @param s - a string to check the password against
	 * @return true if the password matches the parameter string, false otherwise
	 * 
	 */
	public boolean checkPassword(String s) {
		return s.equals(password);
	}
	
	
	
		
	
}
