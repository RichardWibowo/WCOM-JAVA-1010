import java.util.ArrayList;
import java.util.ListIterator;

public class Exercises {

	public static void main(String[] args) {

		ArrayList<Double> dlist = new ArrayList<Double>();

		// 1.		Add 4 doubles to the above array list
		
		dlist.add(4.5);
		dlist.add(3.6);
		dlist.add(1.9);
		dlist.add(3.8);

		// 2.		Print the size of the array list
		
		System.out.println(dlist.size());

		// 3.		Add -0.5 at index 1 and index 3 in the above array list
		
		dlist.add(1,-0.5);
		dlist.add(3,-0.5);
		
		// 4.		Remove -0.5 from the array list using list.remove(Double)
		
		Double rem = -0.5;
		dlist.remove(rem);

		// 5.		Print the contents of the array list
		
		System.out.println(dlist);
		
		//			Were both -0.5's removed from the list?
		//			If not, which was removed and which wasn't? Comment your answers
		
		// Only the first -0.5 was removed

		// 6.		Set the double in index 3 of the list to 0.99
		//			Note this means using list.set(int,Double)
		
		dlist.set(3,0.99);

		// 7.		Print the double at index 3.
		//			Did the above set work?
		
		System.out.println(dlist.get(3));

		// 8.		Print the index of -0.5 in the array list.
		//			Note this means using indexOf
		
		System.out.println(dlist.indexOf(-0.5));

		// 9.   Print each double in the array list on a separate line
		
		for(Double item : dlist) {
			System.out.println(item);
		}

		// 10.	Calculate the sum of all doubles in the array list
		//			Store your result in a variable called sum.
		//			Print the result of your sum to confirm it is correct
		
		double dsum = 0;
		
		for(Double item : dlist) {
			dsum += item;
		}
		
		System.out.println(dsum);

		// 11.	Create a new array list called slist which contains String objects
		
		ArrayList<String> slist = new ArrayList<String>();

		// 12. 	Add 6 names to your array list.
		//		 	You can use your friends names or class mates names
		
		slist.add("Daniel");
		slist.add("Sam");
		slist.add("Alice");
		slist.add("James");
		slist.add("Jessica");
		slist.add("Michael");

		// 13.	Create a String called firstLetters which contains the first
		//			letter of each name in the array list.
		// Ex:	if list = {"John","Andy","Kate","Lenny"}
		//			the firstLetters = "JAKL"
		//			Print firstLetters to check your result
		
		String firstLetters = "";
		
		for(String item : slist) {
			firstLetters += item.charAt(0);
		}
		
		System.out.println(firstLetters);

		// 14.	Use a ListIterator to print all names in slist on one line with
		//			a comma in between them.
		//			Note: System.out.print() will print on one line.
		// Ex:	if slist = {"John","Andy","Kate","Lenny"}
		//			the it should print:
		//			John,Andy,Kate,Lenny
		
		ListIterator<String> iter = slist.listIterator();
		String toPrint = "{";
		
		while(iter.hasNext()) {
			toPrint+="\""+iter.next()+"\",";
		}
		
		toPrint = toPrint.substring(0,toPrint.length()-1)+"}";
		
		System.out.println(toPrint);

	}

	// 15.	Complete the below method
	// The method should set all negative numbers in the list to 0.
	public static void noNegatives(ArrayList<Double> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i)<0) {
				list.set(i, 0.0);
			}
		}
	}

	// 16.	Complete the below method
	// The method should print only the negative numbers in the list.
	// Use the list iterator
	public static void printNegatives(ArrayList<Double> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i)<0) {
				System.out.println(list.get(i));
			}
		}
	}

	// 17.	Complete the below method
	// The method should return the largest number in the list
	// Use a for each loop
	public static double getMax ( ArrayList <Double > list ) {
		
		double max = list.get(0);
		
		for(Double item : list) {
			if(item > max) {
				item = max;
			}
		}
		
		return max;
	}

	// 18.	Complete the below method
	// The method should return the sum of the squared values in lists
	// Use a for each loop
	// Ex:	if list = {2,3,4}
	//			then return 4 + 9 + 16
	public static int sumSquares ( ArrayList <Integer > list ) {
		
		int sum = 0;
		
		for(Integer item : list) {
			sum += item*item;
		}
		
		return sum;
	}

	// 19.	Complete the below method
	// The method should remove all Strings in the list which have a length
	// smaller than minLength.
	public static void removeTooSmall ( ArrayList <String> list, int minLength) {

		for(int i = 0; i < list.size(); i++) {
			
			if(list.get(i).length()<minLength) {
				list.remove(i);
			}
			
		}
	}

	// 20.	Complete the below method
	// The method should restrict the length of all strings in the list to
	// maxLength.
	// Ex:	if list = {"John","Andy","Kate","Lenny"} and maxLength = 2
	//			The method should change list to:
	//			list = {"Jo","An","Ka","Le"}
	public static void truncate ( ArrayList <String> list, int maxLength) {
		
		for(int i = 0; i < list.size(); i++) {
			
			list.set(i, list.get(i).substring(0,maxLength));
		
		}
			
	}

}
