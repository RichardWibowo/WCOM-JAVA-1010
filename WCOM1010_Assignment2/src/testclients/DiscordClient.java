package testclients;

import java.util.ArrayList;

import questions.Discord;
import questions.Post;
import questions.Server;
import questions.User;

public class DiscordClient {

	public static void main(String[] args) {

		Discord d = new Discord();

		d.getServers().add(ServerClient.getMUIC());
		d.getServers().add(ServerClient.getGamers());
		d.getServers().add(ServerClient.getHackers());

		System.out.println("--- Testing viewDiscord ---");
		d.viewDiscord();

		System.out.println("\n\n--- Testing searchResults ---");
		d.searchResults("ill");

		System.out.println("\n\n--- Testing userPosts ---");
		User u1 = new User("kyly", "vrpro@wew.com", "ilovevr");
		d.userPosts(u1);

		System.out.println("\n\n--- Testing serversInCommon ---");
		// MUIC and Hackers
		User u2 = new User("lucidbb", "daveed@deveed.com", "mdivad");
		ArrayList<Server> common = d.serversInCommon(u1, u2);
		if (common != null) {
			for (Server s : common) {
				System.out.println(s.getName());
			}
		} else {
			System.out.println("Method incomplete");
		}

		System.out.println("\n\n--- Testing serversInCommon again ---");
		// All
		u1 = new User("kyly", "vrpro@wew.com", "ilovevr");
		u2 = new User("Obie", "obie@one.com", "rabbit");
		common = d.serversInCommon(u1, u2);
		if (common != null) {
			for (Server s : common) {
				System.out.println(s.getName());
			}
		} else {
			System.out.println("Method incomplete");
		}

		System.out.println("\n\n--- Testing serversInCommon again again---");
		// MUIC
		u1 = new User("kyly", "vrpro@wew.com", "ilovevr");
		u2 = new User("WavyGrainz", "cache@csgo.com", "h3k3rr");
		common = d.serversInCommon(u1, u2);
		if (common != null) {
			for (Server s : common) {
				System.out.println(s.getName());
			}
		} else {
			System.out.println("Method incomplete");
		}

		System.out.println("\n\n--- Testing banUser ---");
		System.out.println("Objects removed: " + d.banUser(u1));
		System.out.println("Objects removed: " + d.banUser(u2));
		u2 = new User("lucidbb", "daveed@deveed.com", "mdivad");
		System.out.println("Objects removed: " + d.banUser(u2));
	}

}
