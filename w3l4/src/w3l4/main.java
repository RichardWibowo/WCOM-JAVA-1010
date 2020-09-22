package w3l4;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,1};
		System.out.println(hasDuplicates(arr));
	}
	public static boolean hasDuplicates(int[]arr){
		for(int i= 0; i<arr.length; i++){
			for(int j= i+ 1; j <arr.length; j++){
				if(arr[i] == arr[j]) 
					return true;
				}
			}
		return false;
		}
	public static boolean hasDuplicatesStr(String[]arr){
		for(int i= 0; i<arr.length; i++){
			for(int j= i+ 1; j <arr.length; j++){
				if(arr[i].equals(arr[j])) 
					return true;
				}
			}
		return false;
		}
	public static boolean hasDouble(int[]arr){
		for(int i= 0; i<arr.length; i++){
			for(int j= i+ 1; j <arr.length; j++){
				if(arr[i]*2 ==arr[j]) 
					return true;
				}
			}
		return false;
		}
	public static int isUnique(int[]arr){
		int count = 0;
		for(int i= 0; i<arr.length; i++){
			boolean unique = true;
			for(int j= i+ 1; j <arr.length; j++){
				if(arr[i]!=arr[j] && i!=j) 
					unique =false;
				}
			if(unique = true) {
				count ++;	
		}
		}
		return count;
		}
	
	
	
}
