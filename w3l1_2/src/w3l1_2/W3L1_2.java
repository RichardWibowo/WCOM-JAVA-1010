package w3l1_2;

public class W3L1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 6, 7, 1, 9, 2, 8, 3 };
		System.out.println(indexOf(arr, 8));
		System.out.println(findDouble(arr, 3));
		double[] arr1 = { 5, 6, 7, 1, 9, 2, 8, 3, 4.5 };
		System.out.println(lastIndexOf(arr1, 4.5));

		String[] stringArr = { "WCOM1000", "MATH135", "WCOM1010", "WCOM1750" };
		System.out.println(stringIndexOf(stringArr, "W"));
	
		double[] D= {1.50, 6.23, 5.34, 9.52, 10.00};
		
		double[]A= {3.6,1.0,2.5,8.9,0.4};
		double result=searchBelow(A,1.0);
		System.out.println(result);
		
		
		double[]B= {3.6,1.0,2.5,8.9,0.4};
		double resultUpper=searchUpper(B,7.5);
		System.out.println(resultUpper);
	
	}

	public static int indexOf(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static int findDouble(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 2 * target) {
				return i;
			}
		}
		return -1;
	}

	public static int lastIndexOf(double[] arr, double target) {
		for (int i = arr.length - 1; i <= 0; i--) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static int stringIndexOf(String[] arr, String target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].contains(target)) {
				return i;
			}
		}
		return -1;
	}

	public static Boolean hasSpace(String target) {
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) == ' ') {
				return true;
			}
		}
		return false;
	}

	public static int sameLength(String[] target, String lesson) {
		for (int i = 0; i < target.length; i++) {
			if (target[i].length() == lesson.length()) {
				return i;
			}
		}
		return -1;
	}

public static int startWith (String[] target,String lesson){
	for(int i= 0;i< target.length; i++){
		if(target[i].startsWith(lesson)){
			return i;
			}
		}
	return -1;
  }

public static int searchRange(double[]arr,double min, double max){
	for(int i= 0;i< arr.length; i++){
		if(arr[i] >= min && arr[i] <= max){
			return i;
			}
		}
	return -1;
		}




public static double searchBelow(double[]arr,double min){
	for(int i= 0;i< arr.length; i++){
		if(arr[i] <min ){
			return arr[i];
			}
		}
	return -1;
		}


public static double searchUpper(double[]arr,double max){
	for(int i= 0;i< arr.length; i++){
		if(arr[i] > max ){
			return arr[i];
			}
		}
	return -1;
		}
}







