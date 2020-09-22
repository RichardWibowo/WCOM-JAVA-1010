package w2l1;

import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*player objPlayer = new player();
		objPlayer.setName("da wae");
		objPlayer.setSize(140);
		
		player objPlayer2 = new player();
		objPlayer2.setName("mike");
		objPlayer2.setSize(69);
		
		player p = new player();
		
		player p2 = new player("jack", 1);
		p2.eat();
		
		System.out.println(objPlayer);
		System.out.println(objPlayer2);
		System.out.println();
		System.out.println(objPlayer.getName());
		System.out.println(objPlayer.getSize());
		System.out.println();
		System.out.println(objPlayer2.getName());
		System.out.println(objPlayer2.getSize());
		System.out.println();
		System.out.println(p.getName());
		System.out.println(p.getSize());
		System.out.println();
		System.out.println(p2.getName());
		System.out.println(p2.getSize());
		
		*/
		player x = new player("mike",5);
		player y = new player("daniel", 20);
		System.out.println(x.booleanequals(y));
		System.out.println(y.compareTo(x));
		
			player[] players= new player[5];
			players[0] = new player("Daniel",100);
			players[1] = new player("mike",30);
			players[2] = new player("jake",40);
			players[3] = new player("pepee",69);
			players[4] = new player("KEKW",50);
			System.out.println(Arrays.toString(players));
			
			System.out.println(players[3].getSize());
			
			players[3].eat();
			
			System.out.println(players[3]);
	
	}

}
