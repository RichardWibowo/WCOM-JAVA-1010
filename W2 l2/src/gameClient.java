
public class gameClient {
	public static void main(String[]args) {
		
		Game g = new Game();
		for(int i = 0; i < g.getPlayer().length;i++) {
			System.out.println(g.getPlayer(i));
		}
	}
}
