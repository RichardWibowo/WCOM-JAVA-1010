import java.util.Arrays;

public class ShoppingList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			FOOD[] products = new FOOD[5];
			
			products[0] = new FOOD("milk",2);
			products[1] = new FOOD("soggy fries", 99999);
			products[2] = new FOOD ("nuttela",5);
			products[3] = new FOOD ("rawon", 30);
			products[4] = new FOOD("salad",10);
			
			//sortPrice(products);
			sortName(products);
			System.out.println(Arrays.toString(products));
	}
	public static void sortPrice(FOOD[]arr) {
		for(int i = 0;i<arr.length;i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx].getPrice() > arr[j].getPrice())
					minIdx = j;
			}
			FOOD backup = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = backup;
		}
	}
	public static void sortName(FOOD[]arr) {
		for(int i = 0;i<arr.length;i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx].getName().charAt(0) > arr[j].getName().charAt(0))
					minIdx = j;
			}
			FOOD backup = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = backup;
		}
	}	
	}


