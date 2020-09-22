
class Game {
	private player[] players;
	
	public Game(){
		 players = new player[4];
		
		for(int i= 0; i< players.length; i++){
			players[i] = new player("Player "+i,5);
			}
		}
	public player[] getPlayer() {
		return players;
	}
	
	public player getPlayer(int idx) {
		return players[idx];
	}

}
