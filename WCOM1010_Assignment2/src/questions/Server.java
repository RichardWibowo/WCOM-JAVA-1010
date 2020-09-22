package questions;

import java.util.ArrayList;

public class Server {
	ArrayList<Channel> channels;
	ArrayList<User> users;
	String name;
	
	/**
	 * 2 marks
	 * @param username - the username to search for
	 * @return true if the user has posted within any of the Channel objects 
	 * 		   in the channels ArrayList.
	 *         return false otherwise.
	 * 
	 */
	public boolean hasPosted(User u) {
		// To be completed
			for(int i = 0; i<channels.size();i++) {
				if(channels.get(i).hasUser(u)) {
					return true;
				}
			}
		return false;
	}
	
	/**
	 * 2 marks
	 * This method should print the server name followed by all of the channels
	 * within the server and their messages.
	 * 
	 * Hint: use viewChannel
	 */
	public void viewServer() {
		// To be completed
		System.out.println(name);
		for(Channel item : channels) {
			System.out.println(item);
			for(Channel Item2 :channels) {
				System.out.println(Item2.getPosts());
			}
		}
			
	}
	
	/**
	 * 
	 * @param u - the user to search for
	 * 
	 * @return an ArrayList which contains
	 * all of the posts within the Servers Channel objects that were posted
	 * by the parameter user u.
	 * 
	 */
	public ArrayList<Post> getAllPostsByUser(User u) {
		// To be completed
		ArrayList<Post> answer = new ArrayList<Post>();
		for(int i=0;i<channels.size();i++) { 
			
			for(int j=0;j<channels.get(i).getPosts().size();j++){ 
			
				if(channels.get(i).getPosts().get(j).getPoster().getUsername().equals(u.getUsername())){
			
					answer.add(channels.get(i).getPosts().get(j));
					}
				}
			} 
			return answer;
			}
	
	/**
	 * 
	 * This method should delete all Posts made by the parameter
	 * user u throughout the Server. The method should then
	 * return the number of posts that were removed.
	 * 
	 * @param u
	 * @return the number of posts removed.
	 */
	public int deletePostsByUser(User u) {
		// To be completed
		int count = 0;
		for(int i = 0;i<channels.size();i++) {
			if(channels.get(i).hasUser(u)) {
				channels.get(i).removePost(i);
				count ++;
			}
		}
		return count;
	}
	
	/**
	 * This method should return the Channel object
	 * in the ArrayList channels which has the most Posts.
	 * @return
	 */
	public Channel getChannelMostPosts() {
		int mostPost = channels.get(0).getPosts().size();
		Channel answer = channels.get(0);
		
		for(int i = 0;i < channels.size();i++) {
			if(channels.get(i).getPosts().size()>mostPost) {
				mostPost = channels.get(i).getPosts().size();
				answer = channels.get(i);
			}
		}
		
		return answer;
	}
	
	
	/**
	 * This method should return the Channel object
	 * in the ArrayList channels which has the most unique Users.
	 * @return
	 */
	public Channel getChannelMostUsers() {
		// To be completed
	        Integer mostUsers = channels.get(0).uniqueUsers();
	        Channel answer = channels.get(0);

	        for (int i = 0; i < channels.size(); i++) {
	            if (channels.get(i).uniqueUsers() > mostUsers) {
	                mostUsers = channels.get(i).uniqueUsers();
	                answer = channels.get(i);
	                
	            }
	        }
	        return answer;
	}
	/**
	 * 
	 * DO NOT EDIT THE BELOW CODE
	 * 
	 */
	public Server(String name) {
		this.name = name;
		channels = new ArrayList<Channel>();
		users = new ArrayList<User>();
	}
	public ArrayList<Channel> getChannels() {
		return channels;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public String getName() {
		return name;
	}
	
}
