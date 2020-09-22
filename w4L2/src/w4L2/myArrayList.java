package w4L2;

public class myArrayList {

	private int[] data;

	public int[] getData() {
		return data;
	}

	public int getData(int idx) {
		return data[idx];
	}

	public void setData(int idx, int value) {
		data[idx] = value;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public myArrayList() {
		data = null;
	}

	public myArrayList(int[] data) {
		setData(data);
	}

	public int size(){
		return data.length;
	}

	public void add(int value){
		int[] arr= new int[data.length+1];
		for(int i= 0; i<data.length; i++){
			arr[i] = data[i];
			}
		arr[arr.length-1] = value;
	data= arr;
	}
	public void add(int idx,int value){
		int[] arr= new int[data.length+1];
		for(int i= 0; i<data.length; i++)
		{
			arr[i] = data[i];
		}
		for(int i = idx ;i<data.length;i++) {
			arr[i+1]= data [i];
		}
		arr[idx] = value;
		data= arr;
	}
	
	
	public String toString() {
		String s = "{";
		for(int i =0; i<data.length;i++) {
			s+=data[i];
			if(i < data.length-1) {
			s+= ",";
			
			}
			}
		return s +"}";
	}
	
	public void remove(int idx) {
		int[] arr= new int[data.length-1];
		for(int i= 0; i<idx; i++){
			arr[i] = data[i];
		}
		for(int i = idx+1 ;i<data.length;i++) {
			arr[i-1]= data [i];
		}
		data= arr;
	}
}
