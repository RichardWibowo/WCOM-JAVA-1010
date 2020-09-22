package w3l1_2;

public class W3L2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] stringArr = { "WCOM1000", "MATH135", "WCOM1010", "WCOM1750" };
		String[] answer = getAllContaining(stringArr,"W");
		for(int i = 0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}

	public static String[]getAllContaining(String[]arr,String target){
		int count= 0;
		for(int i= 0;i< arr.length; i++){
			if(arr[i].contains(target)){
				count++;
				}
			}
		String[]ans=new String[count];
		int k= 0;
		for(int i= 0;i< arr.length; i++){
			if(arr[i].contains(target)){
				ans[k] = arr[i];k++;
				}
			}
		return ans;
		}
}
