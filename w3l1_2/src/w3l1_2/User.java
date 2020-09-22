package w3l1_2;

public class User {

		private double balance;
		private String Name;
	
		
		public double getBalance() {
		return balance;
	}
	public String getName() {
		return Name;
	}
	public void setBalance(double balance) {
		this.balance=balance;
		
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public User(String name,double balance) {
		setName(name);
		setBalance(balance);
	}
	public String toString() {
		return Name+" BALANCE == "+ balance;
	}
	

}
