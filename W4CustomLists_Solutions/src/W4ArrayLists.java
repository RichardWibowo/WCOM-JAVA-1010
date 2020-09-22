import java.util.ArrayList;

public class W4ArrayLists {

	public static void main(String[] args) {

		// Slide 9
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// Slide 12
		list.add(3);
		list.add(8);
		list.add(10);
		list.add(32);
		
		list.add(2,11);
		list.add(0,1);
		list.add(-5); // This automatically adds to the end of the list
		// list.add(199,1001); // We comment this out because our list is not 199 long so we see an OutOfBounds error.
		
		// Slide 14
		System.out.println(list.size());
		
		System.out.println(list.get(3));
		
		System.out.println(list.get(list.size()-1));
		
		System.out.println(list.get(2)*list.get(4));
		
		// System.out.println(list.get(40)); // There is no item in index 40 so we see an OutOfBounds error.
		
		list.remove(4);
		
		Integer rem = 8;
		
		list.remove(rem);
		
		rem = 999;
		
		System.out.println(list.remove(rem)); // Should print false since 999 is not in the list
		
		// System.out.println(list.remove(33)); // There is no item in index 33 so we see an OutOfBounds error.
		
		// Slide 18
		System.out.println(list.toString());
		
		list.set(2, 12);
		
		System.out.println(list); // Remember, we don't have to write toString()
		
		// System.out.println(list.set(100,1)); // There is no item in index 100 so we see an OutOfBounds error.
		
		// Slide 20
		Integer n = 12;
		
		System.out.println(list.indexOf(n));
		
		n = 75;
		
		System.out.println(list.contains(n));
		
		System.out.println(list.indexOf(n));
		
		// Slide 26
		
		System.out.println("Learning loops");
		
		System.out.println(list);
		
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			
			sum+= list.get(i);
			
		}
		
		System.out.println(sum);
		
		// Set all negatives to zero
		for(int i = 0; i < list.size(); i++) {
			
			if(list.get(i)<0) {
				list.set(i, 0);
			}
			
		}
		
		System.out.println(list);
		
		// Add 1 to every entry
		for(int i = 0; i < list.size(); i++) {
			
			list.set(i, list.get(i)+1);
			
		}
		
		System.out.println(list);
		
		// Slide 28
		int product = 1;
		for(Integer item : list) {
			product *= item;
		}
		
		System.out.println(product);
		
		// sum of all even integers
		int sumEven = 0;
		for(Integer item : list) {
			if(item%2==0) {
				sumEven+=item;
			}
		}
		
		System.out.println(sumEven);
		
		// Add odd numbers to odds ArrayList
		ArrayList<Integer> odds = new ArrayList<Integer>();
		for(Integer item : list) {
			if(item%2!=0) {
				odds.add(item);
			}
		}
		
		System.out.println(odds);
		
	}

}
