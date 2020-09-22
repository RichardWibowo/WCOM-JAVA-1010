package w3l5;

import java.util.Arrays;

public class searcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//double[]arr= {4.5,6.1,5.5,4.5,8.0};
		//int result=lastIndexOf(arr,4.5);
		//System.out.println(result);
		//String[]arr= {"Apple","Orange","Pear","Pine"};
		//int result=sameLast(arr,"ar");
		//System.out.println(result);
		double[]arr1= {3.6,1.0,2.5,8.9,0.4};
		double result1=findAbove(arr1,7.5);
		System.out.println(result1);
		String[]arr= {"Ice","Pencil","Ruler","Helmet"};
		String[] result=getLengthIn(arr,4,6);
		System.out.println(Arrays.toString(result));
	}
	public static int lastIndexOf(double[]arr,double Target) {
		
		for(int i =arr.length-1;i>=0;i--) {
			if(arr[i] == Target) {
				return i;
			}
		}
		return -1;
	}
	public static int sameFirst(String[]arr,String Target) {
		int count = 0;
		for(int i = 0; i<arr.length;i++) {
			if(arr[i].charAt(0)==(Target.charAt(0))) {
				count++;
			}
		}
		return count;
	}
	public static int sameLast(String[]arr,String Target) {
		int count = 0;
		for(int i = 0; i<arr.length;i++) {
			if(arr[i].endsWith(Target)) {
				count++;
			}
		}
		return count;
	}
	public static double findAbove(double[]arr,double Target) {
		for(int i = 0; i<arr.length;i++) {
			if(arr[i]>=Target) {
				return arr[i];
			}
		}return -1;
	}
	public static int lengthIn(String[]arr,int min, int max) {
		int count =0;
		for(int i = 0; i<arr.length;i++){
			if(arr[i].length()<max&&arr[i].length()>min) {
				count++;
			}
		}return count;
	}
	public static String[] getLengthIn(String[]arr,int min, int max) {
		int count =0;
		for(int i = 0; i<arr.length;i++){
			if(arr[i].length()<=max&&arr[i].length()>=min) {
				count++;
			}
		}int z =0;
		String[]ans = new String[count];
		for(int j = 0; j<arr.length;j++){
			if(arr[j].length()<=max&&arr[j].length()>=min) {
				ans[z]=arr[j];
			}
		}
		return ans;	
	}
	
}
