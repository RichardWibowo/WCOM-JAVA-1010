package questions;

public class User {
	
	private String username;
	private String password;
	private String email;
	
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	
	public void setUsername(String u) {
		// To be completed
		if(u.length()<1) {
			u = "Discordian";
		}
		username = Character.toUpperCase(u.charAt(0))+u.substring(1);
	}
	
	public void setPassword(String p) {
		// To be completed
		boolean upper = false;
		boolean lower = false;
		for(int i = 0; i < p.length(); i++) {
			if(Character.isUpperCase(p.charAt(i))) {
				upper = true;
			}
			if(Character.isLowerCase(p.charAt(i))) {
				lower = true;
			}
		}
		if(!(upper&&lower)) {
			p = p + "!1!";
		}
		password = p;
	}
	
	public void setEmail(String e) {
		// To be completed
		if(e.indexOf("@")==-1) {
			e = "discordian@discord.com";
		}
		email = e.toLowerCase();
	}
	
	public User(String username, String email, String password) {
		// To be completed
		setUsername(username);
		setEmail(email);
		setPassword(password);
	}
	
	public boolean equals(User u) {
		// To be completed
		return u.getEmail().equals(email)
						&&u.getUsername().equals(username)
						&&u.checkPassword(password);
	}
	
	public String toString() {
		// To be completed
		return "Username: "+username+", Email: "+email;
	}
	
	/**
	 * DO NOT EDIT THE BELOW CODE
	 */
	public User() {}
	public boolean checkPassword(String s) {
		return s.equals(password);
	}
}
