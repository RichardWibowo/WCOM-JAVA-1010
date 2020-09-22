package questions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Channel {
	
	User[] users; // An array to store all the users in the channel
	Post[] posts; // An array to store all the posts in the channel
		
	/**
	 * 
	 * 3 marks
	 * 
	 * The users array will contain either User objects or null entries.
	 * 
	 * @return the number of users within the Channel.
	 * 
	 */
	public int countUsers() {
		// To be completed
		int counter = 0;
		for (int i = 0; i < users.length; i ++) {
		    if (users[i] != null) {
		        counter ++;
		    }
		}
		return counter;
	}
		
	/**
	 * 
	 * 5 marks
	 * 
	 * @param u - the user object
	 * @return the number of posts within the Channel posted by the parameter user.
	 * 
	 * Hint: you can't call a method from null.
	 * 
	 */
	public int countPosts(User u) {
		// To be completed
		int count =0;
		for (int i=0; i < posts.length; i++) {
            if (posts[i] != null && posts[i].poster.equals(u) ) {
            	count++;
            }
		}		
		return count;
	}
	
	/**
	 * 
	 * 5 marks
	 * 
	 * @param username - the username to search for
	 * @return first user in the users array whose username is equal to the 
	 * parameter variable username. Return null if no user is found.
	 * 
	 */
	public User findUser(String username) {
		// To be completed
	        for(int i = 0; i < users.length; i++) {
	        	if((users[i] != null && users[i].getUsername().contains(username))) {
	        		return getUser(i);
	        	}
	        }return null;
			}
	

	
	/**
	 * 
	 * 5 marks 
	 * 
	 * @param u - the user to remove
	 * 
	 * This method should remove the parameter user object from the
	 * users array (by setting the entry to null).
	 * 
	 * It should also remove all Post objects in the posts array
	 * which are associated to the parameter user object.
	 * 
	 */
	public void removeUser(User u) {
		// To be completed
		for(int i = 0; i<users.length;i++) {
			if(users[i] != null && users[i].equals(u)) {
				users[i]= null;
			if(posts[i] != null && posts[i].getPoster().equals(u)) {
	            posts[i] = null;
			
				}
			}
		}
	}
	
	/**
	 * 
	 * 10 marks
	 * 
	 * This method should search through the posts array and return
	 * an array of Post objects whose message contains the parameter term.
	 * 
	 * @param term
	 * @return an array of Post objects whose message contains the parameter term.
	 * If no Post objects are found, the method should return an empty array.
	 * 
	 */
	public Post[] searchPosts(String term) {
	           int count = 0;
	            for(int i = 0; i < posts.length; i++) {
	                if(posts[i] != null && posts[i].getMessage().contains(term)) {
	                  count++;
	                }
	            }
	            Post[] containsMsg = new Post[count];
	            for(int i = 0; i < posts.length; i++) {
	                if(posts[i] != null && posts[i].getMessage().contains(term)) {
					containsMsg[i] = posts[i];
	                }
	            }
	            return containsMsg;
	        }
	
	
	/**
	 * 
	 * 10 marks
	 * 
	 * @return an array containing all User objects in the users array who are "turbo users"
	 * If no turbo users are found, the method should return an empty array
	 * 
	 */
	public User[] getTurbo() {
		// To be completed
		int x =0;
		for(int i = 0;i<users.length;i++) {
			if(users[i]!=null&& users[i].isTurbo()) {
				x++;
			}
		}
		User[] personTurbo =new User[x];
		for(int i = 0;i<users.length;i++) {
			if(users[i]!=null&& users[i].isTurbo()) {
				personTurbo[i] = users[i];
			}
		}
		return personTurbo;
	}
		
	/**
	 * 
	 * 10 marks
	 * 
	 * @return The User object in the instance array users which has the 
	 * most Post objects in the instance array posts.
	 * 
	 */
	public User getUserWithMostPosts() {
		// To be completed
		int x =0; String y ="";
		for(int i = 0;i<users.length;i++) {
			if(users[i] != null && x < countPosts(users[i])) {
				x = countPosts(users[i]);
			}y = users[i].getUsername();
			
		}
		return findUser(y);
	}
	
	/**
	 * 
	 * 10 marks
	 * 
	 * @param otherUsers - an array of User objects
	 * 
	 * @return true if the users array contains all the User objects stored
	 * within the parameter array otherUsers. Return false otherwise.
	 * 
	 */
	public boolean contains(User[] otherUsers) {
		// To be completed
		for(int i = 0; i < users.length-1;i++){
            for(int j = i+1; j <= otherUsers.length;j++){
                if(users[i].equals(otherUsers[j])){
                	return true;
                }
              }
            }
		return false;
		
	}
	
	/**
	 * 
	 * DO NOT EDIT THE BELOW CODE
	 * 
	 */
	public Channel(String input) throws IOException {
		users = new User[50];
		posts = new Post[100];
		FileInputStream inputStream1 = new FileInputStream(input);
		BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream1));

		int count = 0;
		while (bufferedReader1.readLine() != null) {
			count++;
		}
		bufferedReader1.close();

		FileInputStream inputStream2 = new FileInputStream(input);
		BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream2));
		
		String line = null;
		int msgi = 0;
		for (int i = 0; i < count; i++) {
			line = bufferedReader2.readLine();
			String[] tokens = line.split(",");
			boolean turbo = Boolean.parseBoolean(tokens[3]);
			User u = new User(tokens[0], tokens[1], tokens[2], turbo);
			users[i] = u;
			String m = tokens[4];
			m = m.substring(1,m.length()-1);
			String[] messages = m.split(";");
			for(String msg : messages) {
				posts[msgi] = new Post(u,msg);
				msgi++;
			}
		}
		bufferedReader2.close();
	}
	public User getUser(int i) {
		return users[i];
	}
	public Post getPost(int i) {
		return posts[i];
	}
}
