package w3l3;

public class w3l3 {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 7, 11, 16, 20, 48 };
		System.out.println(binarySearch(arr, 48));
		System.out.println(binarySearchDesc(arr, 7));
	}

	public static int binarySearch(int[] arr, int target) {
		int first = 0;
		int last = arr.length - 1;
		while (last >= first) {
			int median = (first + last) / 2;
			if (arr[median] == target)
				return median;
			if (arr[median] > target)
				last = median - 1;
			else
				first = median + 1;

		}
		return -1;
	}

	public static int binarySearchDesc(int[] arr, int target) {
		int first = 0;
		int last = arr.length - 1;
		while (last >= first) {
			int median = (first + last) / 2;
			if (arr[median] == target)
				return median;
			if (arr[median] < target)
				last = median - 1;
			else
				first = median + 1;

		}
		return -1;
	}

	public static int binarySearchString(String[] arr, String target) {
		int first = 0;
		int last = arr.length - 1;
		while (last >= first) {
			int median = (first + last) / 2;
			if (arr[median].equals(target))
				return median;
			if (arr[median].charAt(0) > target.charAt(0)) {
				last = median - 1;
			} else {
				first = median + 1;
			}

		}
		return -1;
	}

	public static int binarySearchStrDesc(String[] arr, String target) {
		int first = 0;
		int last = arr.length - 1;

		while (last >= first) {

			int median = (first + last) / 2;
			int result = target.compareTo(arr[median]);

			if (result == 0) {
				return median;
			}
			if (result > 0) {
				last = median - 1;
			} else
				first = median + 1;
		}
		return -1;
	}

	public static int binarySearchUser(User[] arr, User target) {
		int first = 0;
		int last = arr.length - 1;
		while (last >= first) {
			int median = (first + last) / 2;
			if (arr[median].equals(target))
				return median;
			if (arr[median].getBalance() > target.getBalance()) {
				last = median - 1;
			} else {
				first = median + 1;
			}

		}
		return -1;
	}

	public static int getMin(int[] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		return min;
	}
	public static int getMax(int[] arr) {
		int Max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < Max)
				Max = arr[i];
		}
		return Max;
	}
	public static int findLongest(String[] arr) {
		int MaxIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() < arr[MaxIdx].length())
				MaxIdx = i;
		}
		return MaxIdx;
	}
	public static String findShortest(String[] arr) {
		int minIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > arr[minIdx].length())
				minIdx = i;
		}
		return arr[minIdx];
	}
	public static String findRichest(User[] arr) {
		int richIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getBalance()< arr[richIdx].getBalance())
				richIdx = i;
		}
		return arr[richIdx].getName();
}
}