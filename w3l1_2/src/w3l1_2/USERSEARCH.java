package w3l1_2;

import w3l3.User;

public class USERSEARCH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User[]Users = new User[5];
		
		Users[0] = new User("Daniel Ricks",2000);
		Users[1] = new User("Angus Daniels",4587);
		Users[2] = new User("Walter Angus",1278);
		Users[3] = new User("Jim Jerrery",2875);
		Users[4] = new User("Danielle Daniels",3289);
System.out.println(indexOf(Users,"Walter Angus"));
System.out.println(higherBalance(Users,Users[3]));
	}
	public static int indexOf(User[] arr, String Target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getName().equals(Target)) {
				return i;
			}
		}
		return -1;
	}
	public static int higherBalance(User[]arr,User target) {
		int count =0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getBalance() > target.getBalance()) {
				count ++;
			}
		}
		return count;
	}
}
	

