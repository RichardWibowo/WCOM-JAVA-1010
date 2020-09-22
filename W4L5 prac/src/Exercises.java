import java.util.ArrayList;
import java.util.ListIterator;

public class Exercises {

	public static void main(String[] args) {
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		
		drinks.add(new Drink(2.15,"Milk"));
		drinks.add(new Drink(3.15,"ASD"));
		drinks.add(new Drink(6.15,"ZZZ"));
		
		// 1.		Add 5 more drinks to the ArrayList drinks, use realistic names and prices
		drinks.add(new Drink(4.15,"!!!!!!!"));
		drinks.add(new Drink(5.15,"QWE"));
		drinks.add(new Drink(7.15,"WER"));
		drinks.add(new Drink(8.15,"ERT"));
		drinks.add(new Drink(9.15,"RTY"));
		
		// 2.		Create the below methods
		
		// Test your methods here, for example:
		
		System.out.println(countPriceLessThan(drinks,5.5));
		System.out.println(countPriceMoreThan(drinks,8));
		System.out.println(countPriceBetween(drinks,1.0,8.0));
		System.out.println(countWithName(drinks,"Q"));

	}
	
	// Example question / answer:
	// Complete the below method
	// The method should return the number of Drinks which have a price
	// less than minPrice
	public static int countPriceLessThan( ArrayList <Drink> drinks, double minPrice) {
		// Write your code here
		int sum = 0;
		for(Drink item : drinks) {
			if(item.getPrice()>minPrice) {
				sum ++;
			}
		}
		return sum;
	}

	// Complete the below method
	// The method should return the number of Drinks which have a price
	// more than maxPrice
	public static int countPriceMoreThan( ArrayList <Drink> drinks, double maxPrice) {
		// Write your code here
		int sum = 0;
		for(Drink item : drinks) {
			if(item.getPrice()>maxPrice) {
				sum ++;
			}
		}
		return sum;
	}

	// Complete the below method
	// The method should return the number of Drinks which have a price
	// between minPrice and maxPrice (inclusive)
	public static int countPriceBetween( ArrayList <Drink> drinks, double minPrice, double maxPrice) {
		// Write your code here
		int sum = 0;
		for(Drink item : drinks) {
			if(item.getPrice()<maxPrice
			&& item.getPrice()>minPrice) {
				sum ++;
			}
		}
		return sum;
	}

	// Complete the below method
	// The method should return the number of Drinks which contain target
	// within their name.
	// HINT: drinks.get(i).getName().contains(target) will return true if
	// the drinks name contains the target.
	public static int countWithName( ArrayList <Drink> drinks, String target) {
		// Write your code here
		int count = 0;
		for(int i =0;i<drinks.size();i++) {
			if(drinks.get(i).getName().contains(target)) {
				count++;
			}
		}
		return count;
	}
	
	// Complete the below method
	// The method should return the index of the Drink object with the target price.
	// Return -1 if no Drink is found
	public static int findIndexOfDrinkWithPrice( ArrayList <Drink> drinks, double target) {
		// Write your code here
		for(int i =0;i<drinks.size();i++) {
			if(drinks.get(i).getPrice() == target) {
				return i;
			}
		}
		return -1;
	}
	
	// Complete the below method
	// The method should return Drink object with the target price.
	// Return null if no Drink is found
	public static Drink findDrinkWithPrice( ArrayList <Drink> drinks, double target) {
		// Write your code here
		for(Drink item:drinks) {
			if(item.getPrice() == target) {
				return item ;
				
			}
		}
		return null;
	}
	
	// Complete the below method
	// The method should return the a new ArrayList of Drinks which have a price
	// between minPrice and maxPrice (inclusive)
	public static ArrayList<Drink> getDrinksWithPriceBetween( ArrayList <Drink> drinks, double minPrice, double maxPrice) {
		// Write your code here
		ArrayList<Drink> john = new ArrayList<Drink>();
			for(int i = 0; i<drinks.size();i++) {
				if(drinks.get(i).getPrice()>minPrice
				&& drinks.get(i).getPrice()<maxPrice) {
					john.add(drinks.get(i));
				}
					
			}
		return john;
	}
	
	// Complete the below method
	// The method should return the a new ArrayList of Drinks with names that start
	// with the character c.
	public static ArrayList<Drink> getDrinksWithChar( ArrayList <Drink> drinks, char c) {
		// Write your code here
		ArrayList<Drink> john = new ArrayList<Drink>();
		for(Drink item:drinks) {
			if(item.getName().charAt(0)==(c)) {
				john.add(item);
			}
		}
		return john;
	}
	
	// Complete the below method
	// The method set the name of all drinks to uppercase
	public static void upperCaseAll( ArrayList <Drink> drinks) {
		// Write your code here
		for(Drink item:drinks) {
			item.setName(item.getName().toUpperCase());
		}
	}
	// Complete the below method
		// Duplicate every Drink in the arraylist
		// e.g. if it was {"Fanta","Coke","Lemonade"} the
		// each drink object should be duplicated so that the arraylist becomes
		// {"Fanta","Fanta","Coke","Coke","Lemonade","Lemonade"}
		public static void doubleUp(ArrayList<Drink> drinks) {
				for(int i =0;i<drinks.size();i++) {
					drinks.add(i,drinks.get(i));
					i++;
				}
		}
		
		// Complete the below method
		// Delete every drink in the list whose price is less than the maxPrice
		
		public static void removeExpensive(ArrayList<Drink> drinks, double maxPrice) {
			for(int i =0;i<drinks.size();i++) {
				if(drinks.get(i).getPrice()<maxPrice) {
					drinks.remove(drinks.get(i));
					i--;
				}
			}
		}
		public static void remDups(ArrayList<Drink> drinks) {
			for (int i = 0; i < drinks.size(); i++) {
				
				for (int k = i+1; k < drinks.size(); k++) {
					
					if(drinks.get(i).equals(drinks.get(k))) {
						drinks.remove(k);
						k--;
					}
					
				}

			}

		}


	
}
