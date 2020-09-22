package l5w1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static boolean  hasNegative(int [] arr) {
		for(int i = 0; i<arr.length;i++) {
			if(arr[i] < 0) {
				return true;
			}
		}
		return false;
		
	}
	public static boolean hasSpace(String str) {
		for (int i = 0; i<str.length();i++) {
			if(str.charAt(i)==' ') {
				return true;
			}
		}return false;
	}
	public static boolean allEven(int[] arr) {
		for(int i = 0; i<arr.length;i++) {
			if(arr[i] %2 == 1) {
				return true;
			}
		}
		return false;	
	}
	public static boolean allFiveLong(String[] arr) {
		for(int i = 0; i<arr.length;i++) {
			if(arr[i].length() != 5) {
				return true;
			}
		}
		return false;	
	}
	}

