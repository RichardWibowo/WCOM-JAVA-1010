import java.util.Arrays;

public class Sorting {
	public static void main(String[] args) {
		int[] arrI= {7,9,3,1,5,4,9};
		sortLastDig(arrI);
		System.out.println(Arrays.toString(arrI));
		Sortingdesc(arrI);
		System.out.println(Arrays.toString(arrI));
		
		String[] arrS= {"Apple","Open","Jump","Zebra","Ukulele","Nightmare"};
		sortLength(arrS);
		System.out.println(Arrays.toString(arrS));
	}

	public static void sortLastDig(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx] % 10 > arr[j] % 10)
					minIdx = j;
			}
			int backup = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = backup;
		}
	}
	public static void Sortingdesc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[maxIdx]  < arr[j] )
					maxIdx = j;
			}
			int backup = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = backup;
		}
	}
	public static void sortLength(String[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx].length() > arr[j].length())
					minIdx = j;
			}
			String backup = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = backup;
		}
	}
	
}
