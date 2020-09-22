import java.util.Arrays;

public class myArrayList {

	int[] data;

	// Slide 8
	public int[] getData() {
		return data;
	}

	public int get(int i) {
		return data[i];
	}

	public void setData(int[] data) {
		this.data = data;
	}

	// Slide 12
	public void set(int idx, int value) {
		data[idx] = value;
	}

	// Slide 8
	public myArrayList(int[] data) {
		setData(data);
	}

	public myArrayList() {
		data = null;
	}

	// Slide 12
	public int size() {
		return data.length;
	}

	public void clear() {
		data = null;
	}

	// Slide 18
	public void add(int value) {
		
		int[] arr = new int[data.length + 1];
		for (int i = 0; i < data.length; i++) {
			arr[i] = data[i];
		}
		arr[arr.length - 1] = value;
		data = arr;
		
	}
	
	// Slide 20
	public void add(int idx, int value) {
		
		// Make a new array which is 1 longer
		int[] arr = new int[data.length + 1];
		
		// Fill the new array with all the numbers on the left side of data
		for (int i = idx - 1; i >= 0; i--) {
			arr[i] = data[i];
		}
		
		// Fill the new array with all the numbers on the right side of data
		for (int i = idx + 1; i < arr.length; i++) {
			arr[i] = data[i-1];
		}
		
		// Save the new value into the position idx
		arr[idx] = value;
		
		// Overwrite the data with the new, longer array.
		data = arr;
		
	}
	
	// Slide 21
	public int remove(int idx) {
		
		// Make a new array which is 1 shorter
		int[] arr = new int[data.length - 1];

		// Fill the new array with all the numbers on the left side of data
		for (int i = idx - 1; i >= 0; i--) {
			arr[i] = data[i];
		}
		
		// Fill the new array with all the numbers on the right side of data
		for (int i = idx; i < arr.length; i++) {
			arr[i] = data[i+1];
		}
		
		// Backup the number being removed
		int removed = data[idx];

		// Overwrite the data with the new, longer array.
		data = arr;
		
		// Return the item that was removed
		return removed;
		
	}
	
	// Slide 22
	
	// There are two ways to make this method.
	// We can cheat, and use Arrays.toString(data).
	// Or we can create the string ourselves (harder).
	// I will provide the harder solution
	
	public String toString() {
		String s = "[";
		
		for(int i = 0; i < data.length; i++) {
			// Add each number in data and put a comma next to it
			s+=data[i]+",";
		}
		
		// There will be an extra comma, so we need to remove it and add the last ]
		s = s.substring(0,s.length()-1)+"]";
		
		return s;
	}
	
	// Slide 23
	public int indexOf(int target) {
		for(int i = 0; i < data.length; i++) {
			if(data[i]==target) {
				return i;		
			}
		}
		return -1;
	}
	
	public void sort(boolean order) {
		for(int i = 0; i < data.length-1; i++){
			
			int minIdx = i;
			
			for(int j = i + 1; j < data.length; j++){

				if( ( data[minIdx] > data[j] && order ) || ( data[minIdx] < data[j] && !order ) )

						 minIdx 	= j;
				}

				int backup = data[i];
				data[i] = data[minIdx];
				data[minIdx] = backup;
		}
	}

}
