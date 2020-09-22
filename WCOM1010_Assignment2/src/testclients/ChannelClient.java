
package testclients;

import java.util.ArrayList;

import questions.Channel;
import questions.Post;
import questions.User;

public class ChannelClient {

	public static void main(String[] args) {

		// This file can be used to test your Channel.java solutions

		// First lets create an ArrayList to store all the potential users, this will
		// make it easier for us to create posts etc, we can just pick a user from here

		ArrayList<User> users = new ArrayList<User>();
		users.add(new User("kyly", "vrpro@wew.com", "ilovevr"));
		users.add(new User("HavanaBanana", "havabana@hungry.com", "bananatime"));
		users.add(new User("WavyGrainz", "cache@csgo.com", "h3k3rr"));
		users.add(new User("aka_andie", "ctrl@v.com", "nicebackground"));
		users.add(new User("CrushingDonuts", "donut@man.com", "glazed"));
		users.add(new User("Obie", "obie@one.com", "rabbit"));
		users.add(new User("lucidbb", "daveed@deveed.com", "mdivad"));
		users.add(new User("K-T-LO", "the@king.com", "theking"));
		users.add(new User("FlapJak", "flapy@jaky.com", "spongebob"));
		users.add(new User("edobusy", "buona@sera.com", "andiamo"));

		// Now lets make a Channel
		Channel c = new Channel("WCOM1010");

		// New lets add some posts
		// The addWCOM1010Posts method is located below
		// and uses the addPost method withoun the Channel class
		addWCOM1010Posts(users, c);

		// Lets test editing a post
		c.editPost(0, "please can i have some donuts");
		c.editPost(10, "!!!!AYAYYAA!!!");

		// Lets test removing some posts
		c.removePost(3);
		c.removePost(8);

		// Lets print out the chat
		System.out.println("--- Testing add, edit, remove and view ---");
		c.viewChannel();

		System.out.println("\n\n--- Testing hasUser ---");
		// This user has posted
		System.out.println(c.hasUser(users.get(9)));
		// This user hasn't posted
		System.out.println(c.hasUser(users.get(5)));

		System.out.println("\n\n--- Testing getAllPostsByUser ---");
		// Lets get all the posts by kyly
		ArrayList<Post> posts = c.getAllPostsByUser(users.get(0));
		if (posts != null) {
			for (Post p : posts) {
				System.out.println(p);
			}
		}else {
			System.out.println("Method incomplete");
		}
		// Lets get all the posts by K T LO
		posts = c.getAllPostsByUser(users.get(7));
		if (posts != null) {
			for (Post p : posts) {
				System.out.println(p);
			}
		}else {
			System.out.println("Method incomplete");
		}

		System.out.println("\n\n--- Testing searchPosts ---");
		// Search for all posts which contain the letter i
		posts = c.searchPosts("i");
		if (posts != null) {
			for (Post p : posts) {
				System.out.println(p);
			}
		}else {
			System.out.println("Method incomplete");
		}

		System.out.println("\n\n--- Testing uniqueUsers ---");
		// Search for all posts which contain the letter i
		System.out.println("Unique Users: " + c.uniqueUsers());

	}

	public static void addWCOM1010Posts(ArrayList<User> users, Channel c) {
		c.addPost(users.get(4), "i want some donuts");
		c.addPost(users.get(0), "ill get you some");
		c.addPost(users.get(1), "do they have banana flavour?");
		c.addPost(users.get(7), "call me K T LO");
		c.addPost(users.get(8), "you need to get some flap jaks guys!1!!1!");
		c.addPost(users.get(6), "DAVEED");
		c.addPost(users.get(3), "hey everyone");
		c.addPost(users.get(7), "call me K T LO");
		c.addPost(users.get(4), "DELETE ME");
		c.addPost(users.get(7), "call me K T LO");
		c.addPost(users.get(0), "whats goin on");
		c.addPost(users.get(1), "ayyyyyyyy");
		c.addPost(users.get(7), "call me K T LO");
		c.addPost(users.get(9), "benvinuto!");
	}

	public static void addGeneralPosts(ArrayList<User> users, Channel c) {
		c.addPost(users.get(4), "whens uni start again?");
		c.addPost(users.get(6), "last week");
		c.addPost(users.get(4), "srs?");
		c.addPost(users.get(6), "haha yea");
		c.addPost(users.get(4), "whoops");
		c.addPost(users.get(0), "nice one! hahaha");
	}

	public static void addFootballPosts(ArrayList<User> users, Channel c) {
		c.addPost(users.get(0), "anyone keen for a game?");
		c.addPost(users.get(1), "im in, when and where?");
		c.addPost(users.get(0), "mq 9am friday?");
		c.addPost(users.get(0), "anyone else keen?");
		c.addPost(users.get(1), "ill ask around");
		c.addPost(users.get(6), "DAVEED is keen");
		c.addPost(users.get(6), "ill be there, do you have a ball?");
		c.addPost(users.get(0), "i can bring mine, i dont mind though");
		c.addPost(users.get(6), "has anyone else responded?");
		c.addPost(users.get(1), "still waiting");
		c.addPost(users.get(0), "i got another 3 people coming");
		c.addPost(users.get(6), "awesome");
		c.addPost(users.get(7), "im keen to play guys, same time / place?");
		c.addPost(users.get(0), "yea we have around 6 now");
		c.addPost(users.get(1), "cool i have 2 more");
		c.addPost(users.get(1), "see you guys on friday!");
		c.addPost(users.get(6), "let me know if you want me to bring a ball");
		c.addPost(users.get(0), "sure thing");
	}

	public static void addCODPosts(ArrayList<User> users, Channel c) {
		c.addPost(users.get(0), "m4 is the best");
		c.addPost(users.get(3), "naa ak is way better");
		c.addPost(users.get(4), "haha i just rocket everyone from the sky");
		c.addPost(users.get(1), "thats sooo annoying");
		c.addPost(users.get(0), "its so funny though");

	}

	public static void addValorantPosts(ArrayList<User> users, Channel c) {
		c.addPost(users.get(2), "did you guys see jimmy went into a comp");
		c.addPost(users.get(0), "yea i was watching it");
		c.addPost(users.get(3), "i really like this game but its so busy");
		c.addPost(users.get(0), "what do you mean");
		c.addPost(users.get(5), "i think he means so many skills etc");
	}

	public static void addTargetsPosts(ArrayList<User> users, Channel c) {
		c.addPost(users.get(0), "daniel");
		c.addPost(users.get(0), "van");
		c.addPost(users.get(0), "fouhad");
		c.addPost(users.get(2), "kyly");
		c.addPost(users.get(2), "levi");
	}

}
