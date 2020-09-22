public class Client {
	public static void main(String[] args) {
		int result = collatz(3, 0);
		System.out.println(result);
		int[] num = {6,9,1,3};
		int x = 4;
		System.out.println(secret(num,x));
	} // end of main

	public static int collatz(int n, int k) {
		if (n == 1)
			return k;
		if (n % 2 == 0) {
			return collatz(n / 2, k + 1);
		} else {
			int x = 3 * n + 1;
			return collatz(x, k + 1);
		}
	}

	public static int secret(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > x) {
				return arr[i];
			}
		}
		return -1;
	}
}
