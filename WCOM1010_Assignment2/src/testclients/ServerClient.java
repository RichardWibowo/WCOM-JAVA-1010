

package testclients;

import java.util.ArrayList;

import questions.Channel;
import questions.Post;
import questions.Server;
import questions.User;

public class ServerClient {

	public static void main(String[] args) {

		// This file can be used to test your Server.java solutions

		// First lets create a Server object then add some users into it
		// The getMUIC method is below
		Server s = getMUIC();

		// Lets test hasPosted
		System.out.println("--- Testing hasPosted ---");
		// This user has posted
		System.out.println(s.hasPosted(s.getUsers().get(9)));
		// This user hasn't posted
		System.out.println(s.hasPosted(s.getUsers().get(5)));

		System.out.println("\n\n--- Testing viewServer ---");
		s.viewServer();

		System.out.println("\n\n--- Testing getAllPostsByUser ---");
		ArrayList<Post> posts = s.getAllPostsByUser(s.getUsers().get(6));
		if (posts != null) {
			for (Post p : posts) {
				System.out.println(p);
			}
		} else {
			System.out.println("Method incomplete");
		}
		posts = s.getAllPostsByUser(s.getUsers().get(0));
		if (posts != null) {
			for (Post p : s.getAllPostsByUser(s.getUsers().get(0))) {
				System.out.println(p);
			}
		} else {
			System.out.println("Method incomplete");
		}

		System.out.println("\n\n--- Testing getChannelMostPosts ---");
		Channel max = s.getChannelMostPosts();
		if (max != null) {
			System.out.println(max.getName());
		} else {
			System.out.println("Method incomplete");
		}

		System.out.println("\n\n--- Testing getChannelMostUsers ---");
		max = s.getChannelMostUsers();
		if (max != null) {
			System.out.println(max.getName());
		} else {
			System.out.println("Method incomplete");
		}

		System.out.println("\n\n--- Testing deletePostsByUser ---");
		System.out.println("Deleted: " + s.deletePostsByUser(s.getUsers().get(6)));
		System.out.println("Deleted: " + s.deletePostsByUser(s.getUsers().get(3)));
		System.out.println("Deleted: " + s.deletePostsByUser(s.getUsers().get(5)));
	}

	public static Server getMUIC() {
		Server s = new Server("MUIC");
		s.getUsers().add(new User("kyly", "vrpro@wew.com", "ilovevr"));
		s.getUsers().add(new User("HavanaBanana", "havabana@hungry.com", "bananatime"));
		s.getUsers().add(new User("WavyGrainz", "cache@csgo.com", "h3k3rr"));
		s.getUsers().add(new User("aka_andie", "ctrl@v.com", "nicebackground"));
		s.getUsers().add(new User("CrushingDonuts", "donut@man.com", "glazed"));
		s.getUsers().add(new User("Obie", "obie@one.com", "rabbit"));
		s.getUsers().add(new User("lucidbb", "daveed@deveed.com", "mdivad"));
		s.getUsers().add(new User("K-T-LO", "the@king.com", "theking"));
		s.getUsers().add(new User("FlapJak", "flapy@jaky.com", "spongebob"));
		s.getUsers().add(new User("edobusy", "buona@sera.com", "andiamo"));

		// Now lets make some channels and add some posts
		Channel c1 = new Channel("WCOM1010");
		ChannelClient.addWCOM1010Posts(s.getUsers(), c1);
		s.getChannels().add(c1);
		Channel c2 = new Channel("General");
		ChannelClient.addGeneralPosts(s.getUsers(), c2);
		s.getChannels().add(c2);
		Channel c3 = new Channel("Football");
		ChannelClient.addFootballPosts(s.getUsers(), c3);
		s.getChannels().add(c3);

		return s;
	}

	public static Server getGamers() {
		Server s = new Server("Gamers");
		s.getUsers().add(new User("kyly", "vrpro@wew.com", "ilovevr"));
		s.getUsers().add(new User("CrushingDonuts", "donut@man.com", "glazed"));
		s.getUsers().add(new User("Obie", "obie@one.com", "rabbit"));
		s.getUsers().add(new User("K-T-LO", "the@king.com", "theking"));
		s.getUsers().add(new User("FlapJak", "flapy@jaky.com", "spongebob"));
		s.getUsers().add(new User("edobusy", "buona@sera.com", "andiamo"));

		// Now lets make some channels and add some posts
		Channel c2 = new Channel("Valorant");
		ChannelClient.addValorantPosts(s.getUsers(), c2);
		s.getChannels().add(c2);
		Channel c3 = new Channel("COD");
		ChannelClient.addCODPosts(s.getUsers(), c3);
		s.getChannels().add(c3);

		return s;
	}

	public static Server getHackers() {
		Server s = new Server("Hackers");
		s.getUsers().add(new User("kyly", "vrpro@wew.com", "ilovevr"));
		s.getUsers().add(new User("Obie", "obie@one.com", "rabbit"));
		s.getUsers().add(new User("lucidbb", "daveed@deveed.com", "mdivad"));

		// Now lets make some channels and add some posts
		Channel c1 = new Channel("Targets");
		ChannelClient.addTargetsPosts(s.getUsers(), c1);
		s.getChannels().add(c1);

		return s;
	}

}
