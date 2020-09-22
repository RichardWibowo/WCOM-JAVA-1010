package questions;

import java.util.ArrayList;

public class Discord {

	ArrayList<Server> servers;
	
	/**
	 * 2 marks
	 * This method should print all servers stored within the
	 * servers ArrayList.
	 * 
	 * Hint: use viewServers
	 */
	public void viewDiscord() {
		// To be completed
		for(int i = 0;i<servers.size();i++) {
			servers.get(i).viewServer();	
			}
	}
	
	/**
	 * 5 marks
	 * This method should search through the channels within each server
	 * and print the posts which contain the parameter String term.
	 * 
	 * @param term
	 */
	public void searchResults(String term) {
		// To be completed
		for(int i = 0; i < servers.size();i++) {
			for(int j = 0; j < servers.get(i).getChannels().size();j++) {
				for(int k = 0; k < servers.get(i).getChannels().get(j).getPosts().size();k++) {
					if(servers.get(i).getChannels().get(j).getPosts().get(k).getMessage().contains(term)) {
						System.out.println(servers.get(i).getChannels().get(j).getPosts().get(k).getMessage());
						}
					}
				}
			}
		}

	
	/**
	 * 5 marks
	 * This method should print all the posts by
	 * the parameter User u throughout all servers.
	 * 
	 * Each post must be printed on a new line
	 * 
	 * @param u
	 */
	public void userPosts(User u) {
		// To be completed
		for (Server item : servers) {
			System.out.println(item.getAllPostsByUser(u));
		}
	}
	
	/**
	 * 10 marks
	 * This method should remove the parameter user from all servers.
	 * It should also remove all posts made by the parameter user.
	 * 
	 * @param u
	 * @return a count of every user object and post object that was removed.
	 * 
	 */
	public int banUser(User u) {
		// To be completed
		Integer UserBan = 0;
		int count = 0;
		for(int i = 0; i < servers.size();i++) {
			for(int j = 0; j < servers.get(i).getChannels().size();j++) {
				if(i!=j) {		
						servers.get(j).deletePostsByUser(u);
						if(servers.get(j).getUsers().equals(u)) {
							UserBan = servers.get(j).getUsers().indexOf(u);
						}
						servers.remove(UserBan);
						count ++;
						return count;
						}
					}
				}
		return 0;
	}
	
	/**
	 * 10 marks
	 * This user should return an ArrayList which contains all the servers which
	 * the parameter users u1 and u2 have in common.
	 * 
	 * In other words, all the server in which u1 and u2 belong to.
	 * 
	 * @param u1
	 * @param u2
	 * @return an ArrayList of the Server objects both u1 and u2 belong to.
	 * 		   return an empty ArrayList if the users have no servers in common.
	 */
	public ArrayList<Server> serversInCommon(User u1, User u2){
		// To be completed
		ArrayList<Server> answer = new ArrayList<Server>();
		for(Server item : servers) {
						if(item.getUsers().contains(u1)&&item.getUsers().contains(u2)) {
							answer.add(item);
					}
				}
		return answer;
	}
	
	/**
	 * 
	 * DO NOT EDIT THE BELOW CODE
	 * 
	 */
	public Discord() {
		servers = new ArrayList<Server>();
	}
	public ArrayList<Server> getServers() {
		return servers;
	}
	
	
}
