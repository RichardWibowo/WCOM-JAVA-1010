package w5l1;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Link list =new Link();
		list.addFirst(2);
		list.addFirst(300);
		list.addFirst(2000);
		list.addFirst(30000);
		
		System.out.println(list.get(2));
		list.set(1, 450);
		System.out.println(list.get(1));
		System.out.println(list.sum());
		
	}

}
