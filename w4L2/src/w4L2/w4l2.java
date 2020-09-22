package w4L2;


public class w4l2 {
	public static void main(String[]args) {
		
		int[]arr = {3,4,11,2,16};
		myArrayList a = new myArrayList(arr);
	
	System.out.println(a.getData(1));
	
	a.setData(4,30);
	
	System.out.println(a.getData(4));
	
	System.out.println(a.size());
		a.add(20);
	System.out.println(a.size());
	System.out.println(a.getData(3));
	System.out.println(a.getData(4));
	System.out.println(a.getData(5));
	
	System.out.println(a.toString());
	
	a.add(5,6);
	System.out.println(a.toString());
	a.remove(0);
	System.out.println(a.toString());
	}
	
}
