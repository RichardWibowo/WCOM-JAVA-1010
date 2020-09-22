package w3l5;

public class appleSearch {
	public static void main(String[] args) {
		Apple[] apples = new Apple[5];

		apples[0] = new Apple("Jazz",0.98);
		apples[1] = new Apple("Red Delicious",1.59);
		apples[2] = new Apple("Lady",1.85);
		apples[3] = new Apple("Fuji",2.23);
		apples[4] = new Apple("Granny Smith",2.36);


		System.out.println();
	}

	public static int indexOfApple(Apple[] arr, Apple target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getType().equals(target.getType())) {
				return i;
			}
		}
		return -1;
	}

	public static String mostExpenive(Apple[] arr) {
		int maxIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getPrice() > arr[maxIdx].getPrice()) {
				maxIdx = i;
			}
		}
		return arr[maxIdx].getType();
	}
	public static int binarySearchApplePrice(Apple[] arr, Apple target) {
		int first = 0;
		int last =arr.length-1;
			while (last>=first) {
				int median =(first+last)/2;
				if(arr[median].getPrice()==target.getPrice()) {
					return median;
				}
				if(arr[median].getPrice()>target.getPrice()) {
					last = median -1;
				}else {
					first = median +1;
				}
					
			}
			return -1;
		}
	public static int binarySearchAppleType(Apple[] arr, Apple target) {
		int first = 0;
		int last =arr.length-1;
			while (last>=first) {
				int median =(first+last)/2;
				if(arr[median].getType().equals(target.getType())) {
					return median;
				}
				if(arr[median].getType().charAt(0)<target.getType().charAt(0)) {
					last = median -1;
				}else {
					first = median +1;
				}
					
			}
			return -1;
	}
	public static int uniqueApple(Apple[]arr) {
		int count = 0;
		for(int i =0;i<arr.length;i++) {
			boolean unique = true;
			for(int j = 0;j<arr.length;i++) {
				if(i!=j 
					&& arr[i].getType().equals(arr[j].getType())
					&& arr[i].getPrice()==arr[j].getPrice()) {
					unique = false;
				}
			}if(unique) {
				count++;
			}
		}return count;
	}
	
	
}
