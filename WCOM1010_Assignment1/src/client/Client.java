package client;

import java.io.IOException;

import questions.Channel;
import questions.Post;
import questions.User;

public class Client {

	public static void main(String[] args) throws IOException {
		
		// Do not remove the two below lines of code
		Channel channel1 = new Channel("channel1.txt");
		Channel channel2 = new Channel("channel2.txt");
		// Do not remove the two above lines of codes
		
		// Print the number of users in channel 1 (1 marks)
			
		
		// Create a User object named k which stores (0.5 marks): 
		// username = KyLy, email = kyletime@battlenet.com, password = coD4345, turbo = false
			User K = new User("KyLy","kyletime@battlenet.com","coD4345",false);
		
		// Create a User object named d which stores (0.5 marks):
		// username = Daniel, email = daniel@gmail.com, password = GoodPass101, turbo = true
			User D = new User("Daniel","daniel@gmail.com","GoodPass101",true);
			
		// Print the number of posts by KyLy in channel 1 (0.5 marks)
			System.out.println(channel1.countPosts(K));
		// Print the number of posts by Daniel in channel 2 (0.5 marks)	
			System.out.println(channel2.countPosts(D));
		// Search channel 1 for the user with username "Voldex" and 
		// store the result in a variable named v (1 mark)
			User v = channel1.findUser("Voldex");
		
		// Remove all the user with username "Voldex" from both channel 1 and channel 2 (1 mark)
			channel1.removeUser(v);
			channel2.removeUser(v);
		
		// Search through the posts in channel 1 using the term "time" and print each post found
		// to the console. (1 mark)
			Post[] a = channel1.searchPosts("time");
			System.out.println(a);
		
		// Print all the turbo users in channel 1 (1 mark)
			channel1.getTurbo();
		// Create an array of User objects named users with length 3, store users k, d and j in the array (1 mark)
			User[] newUser = new User[3];
			User k = new User("","","",false);
			User d = new User("","","",false);
			User J = new User("","","",false);
		// Print the user in channel 1 who has the most posts (1 mark)
			channel1.getUserWithMostPosts();
		// Determine if channel 1 / channel 2 contain the User objects in the array users and print the results (1 mark)
			channel1.contains(newUser);
			channel2.contains(newUser);
	}

	

}
