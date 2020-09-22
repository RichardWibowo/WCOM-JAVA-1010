package w4l3;

import java.util.ArrayList;

public class w4l4 {
	public static void main(String[]args) {
	int x = 3 ; //primitive data type
	Integer y =3 ;//object
		
		ArrayList<Integer> test = new ArrayList<Integer>();
		System.out.println(test);
		test.add(3);
		test.add(8);
		test.add(10);
		test.add(32);
		
		test.add(0,1);
		
		test.add(-5);
		
		//test.add(199,1001);
		
		System.out.println(test.get(3));
		
		System.out.println(test.size()-1);
		
		System.out.println(test.get(2)*test.get(3));
		
		test.remove(4);//based on the index
		
		System.out.println(test);
		
		test.remove(y);//based on the value
		
		System.out.println(test);
		test.add(50);
		test.set(2, 50);
	
		System.out.println(test.indexOf(50));
		System.out.println(test.lastIndexOf(50));
		
		System.out.println(test.contains(99999));
		int sum = 0;
		for(int i = 0; i<test.size();i++) {
			if(test.get(i)%2==0) {
				sum ++;
			}
		
			}
		System.out.println(sum);
		
		
		
		
		
		//int sum = 0;
		for(int i = 0; i<test.size();i++) {
			if(test.get(i)<0) {
				test.set(i, 0);
			}
		
			}
		System.out.println(test);
		
		
		
		
		
		for(int i = 0; i<test.size();i++) {
			
				test.set(i,test.get(i)+1);
		
			}
		System.out.println(test);
		
		int product =1;
		for(Integer item : test) {
			product *= item;
		}System.out.println(product);
		
		int sumEven =1;
		for(Integer item : test) {
			sumEven += item;
		}System.out.println(sumEven);
		
		ArrayList<Integer>odds = new ArrayList<Integer>();
			for(Integer item : test) {
				if(item%2!=0)
					odds.add(item);
			}System.out.println(odds);
		
		
		
		
		
	}
}
