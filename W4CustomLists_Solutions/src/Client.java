import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
		
		// Slide 9
		
		int[] myData = {3,4,11,2,16};
		
		myArrayList list = new myArrayList(myData);
		
		System.out.println(list.get(3));
		
		// Testing Slide 12
		
		// Test if size works
		System.out.println(list.size());
		
		
		// Test if set works by setting the item in index 1 to 3
		list.set(1, 3);
		
		// Print out the item in index 1, it should now be 3.
		System.out.println(list.get(1));
		
		// Test clear (commented this out so the list is not set to null)
		// list.clear(); 
		
		System.out.println(list.getData()); // Prints null after list.clear()
		
		// Slide 18
		list.add(1);
		System.out.println(Arrays.toString(list.getData())); // Print to see if 1 was added
		list.add(5);
		System.out.println(Arrays.toString(list.getData())); // Print to see if 5 was added
		list.add(8);
		System.out.println(Arrays.toString(list.getData())); // Print to see if 8 was added
		
		System.out.println(list.get(7)); // Check the last number is 8
		
		// Slide 20
		list.add(2,19);
		System.out.println(Arrays.toString(list.getData())); // Print to see if 19 was added
		list.add(0,-5);
		System.out.println(Arrays.toString(list.getData())); // Print to see if -5 was added
		list.add(6,50);
		System.out.println(Arrays.toString(list.getData())); // Print to see if 50 was added
		
		// Slide 21
		// Print something to separate our console
		System.out.println("We are now testing remove(int).");
		
		int rem = list.remove(2); // Store the int returned by the method
		System.out.println(rem); // Print the int that was returned (should be the number removed from the list)
		
		System.out.println(Arrays.toString(list.getData())); // Print to see if the item in index 2 was removed
		
		System.out.println(list.remove(0)); // Print the int returned from the remove method
		System.out.println(Arrays.toString(list.getData())); // Print to see if the item in index 0 was removed
		
		list.remove(6); // Don't store or print the result, it still removes but we don't see what
		System.out.println(Arrays.toString(list.getData())); // Print to see if the item in index 6 was removed
		
		// Slide 23
		// Now we don't have to use Arrays.toString anymore
		// Print something to separate our console
		System.out.println("We are now testing toString()");
		System.out.println(list.toString());
		
		// Remember we don't actually have to write .toString()
		System.out.println(list);
		
		// Slide 24
		// Test indexOf
		System.out.println(list.indexOf(50));
		System.out.println(list.indexOf(5000)); // Should return -1
		
		// Test sort asc
		list.sort(true);
		System.out.println(list);
		
		// Test sort desc
		list.sort(false);
		System.out.println(list);

	}

}
