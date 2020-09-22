package questions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Folder {
	private File[] files;

	

	/**
	 * DO NOT MODIFY
	 * @param files
	 */
	public File getFile(int i) {
		return files[i];
	}
	/**
	 * DO NOT MODIFY
	 * @param files
	 */
	public void setFile(int i, File f) {
		files[i]=f;
	}
	
	/**
	 * DO NOT MODIFY
	 * Loads collection from input file
	 * @param input: name of input file
	 * @throws IOException
	 */
	public Folder(String input) throws IOException {
		FileInputStream inputStream1 = new FileInputStream(input);
		BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream1));

		int count = 0;
		while (bufferedReader1.readLine() != null) {
			count++;
		}
		bufferedReader1.close();

		FileInputStream inputStream2 = new FileInputStream(input);
		BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream2));
		files = new File[count];
		String line = null;
		for (int i = 0; i < count; i++) {
			line = bufferedReader2.readLine();
			String tokens[] = line.split(",");
			String base = tokens[0];
			String ext = tokens[1];
			int size = Integer.parseInt(tokens[2]);
			int perm = Integer.parseInt(tokens[3]);
			files[i] = new File(base, ext, size, perm);
		}
		bufferedReader2.close();
	}

	/**
	 * DO NOT MODIFY
	 * @param files
	 */
	public Folder(File[] files) {
		this.files = files;
	}

	/**
	 * DO NOT MODIFY
	 * @return String representation of the collection
	 */
	public String toString() {
		String result = "";
		for(int i=0; i < files.length; i++) {
			result = result + files[i].toString()+"\n";
		}
		return result+"\n";
	}

	/**
	 * DO NOT MODIFY
	 * @return the total size of the collection.
	 * FOR EXAMPLE, if there are 3 files in the collection,
	 * with sizes 20, 8000 and 700 bytes, the size 
	 * of the collection is 8720 bytes 
	 */
	public int collectionSize() {
		int result = 0;
		for(File file: files)
			result+=file.getSize();
		return result;
	}

	/**
	 * 
	 * @param extension
	 * @return number of files with the given extension
	 * (case insensitive)
	 * NOTE: don't compare Strings using ==
	 * Google "String case insensitive comparison java"
	 */
	public int getCountByExtension(String extension) {
		// to be completed
		int a = 0;
		for(int i = 0; i<files.length;i++) {
			if(files[i].getExtension().equalsIgnoreCase(extension)) {
				a++;
			}
		}
		return a;
	}

	/**
	 * 
	 * @param min
	 * @param max
	 * @return number of files in the given size range 
	 * (inclusive on both sides)
	 */
	public int countFilesInSizeRange(int min, int max) {
		// to be completed
		int count  = 0; 
			for(int i = 0; i < files.length;i++) {
				if(files[1].getSize()>min && files[1].getSize()<=max) {
					count++;
				}
			}
		return count;
	}

	/**
	 * 
	 * @param target
	 * @return first index at which the file passed
	 * as parameter exists in the collection, -1 if file doesn't exist
	 * NOTE: use the equals method defined in File class for comparison, not ==
	 */
	public int indexOf(File target) {
		// to be completed
		for(int i = 0; i < files.length;i++) {
			if (files[i].equals(target)){
				return i ;
			}
		}
		return -1;
	}


	/**
	 * 
	 * @return the name of the biggest file
	 */
	public String getBiggestFilesName() {
		// to be completed
		int maxIdx = 0;
			for(int i = 0; i< files.length; i++) {
				if(files[i].getSize() > files[maxIdx].getSize()) {
					maxIdx = i;
				}
			}
		return files[maxIdx].getName();
	}

	/**
	 * 
	 * @param file
	 * @return the number of times the given file exists 
	 * in the collection.
	 * NOTE: use the equals method defined in File class for comparison, not ==
	 */
	public int count(File file) {
		// to be completed
		return -10;
	}

	/**
	 * HD component 1
	 * 
	 *  This method should return a deep copy of the Folder object
	 *  
	 */
	public Folder copy() {
		//to be completed
		return null;
	}

	/**
	 * HD component 2
	 * 
	 * @param other
	 * 
	 * This method should add all files contained within the parameter Folder other
	 * to the files array.
	 * 
	 */
	public void paste(Folder other) {
		//to be completed
	}


	/**
	 * HD component 3
	 * @param other
	 * @return true if the calling object contains
	 * all files in the parameter object, false otherwise
	 */
	public boolean contains(Folder other) {
		// to be completed
		return true; 
	}

	/**
	 * HD component 4
	 * @param other
	 * @return true if the calling object and parameter object
	 * represent the same collection (it's ok if they are NOT in the same order)
	 */
	public boolean identical(Folder other) {
		// to be completed
		return true;
	}
}
