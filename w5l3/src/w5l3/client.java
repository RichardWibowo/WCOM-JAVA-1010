package w5l3;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countDigit(1234567890));
		System.out.println(factorial(3));
		System.out.println(sumDigit(12));
		System.out.println(prodOddDigits(5234));
	}
	public static int countDigit(int n) {
		if(n<=0) {
			return 0;
		}
		return 1+countDigit(n/10);
	}
	public static int factorial(int n) {
		if(n <= 1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	public static int sumDigit(int n) {
		if(n<=0) {
			return 1;
		}
		return n%10 * sumDigit(n/10);
	}
	public static int prodDigit(int n) {
		if(n<=0) {
			return 1;
		}
		return n%10 * prodDigit(n/10);
	}
	public static boolean hasTargetDigit(int n, int m) {
		if(n<=0) {
			return false;
		}if(n%10==0) {
			return true;
		}
		return hasTargetDigit(n/10,m);
	}

	public static double power(double n, int m) {

		if (m <= 0) {
			return 1;
		}
		return n * power(n, m - 1);
	}
	public static int countDigitOdd(int n) {
		if(n<=0) {
			return 0;
		}if(n%2 != 0) {
		return 1+countDigitOdd(n/10);
	}
	return 0 + countDigitOdd(n/10);
}
	public static int countDigitEven(int n) {
		if(n<=0) {
			return 0;
		}if(n%2 == 0) {
		return 1+countDigitEven(n/10);
	}
	return 0 + countDigitEven(n/10);
}
	public static int prodOddDigits(int n) {
		if(n<=0) {
			return 1;
		}
		if(n%2 != 0) {
			return n % 10 * prodOddDigits(n/10);
		}
		return  prodOddDigits(n/10);
	}
	public static int countTargetDigit(int n,int d) {
		if(n<=0) {
			return 0;
		}if(n%10 == d) {
			return 1+countTargetDigit(n/10,d);
		}
		return 0+countTargetDigit(n/10,d);
	}
	public static int numDivisors(int n,int i) {
		if(n> n/2) {
			return 0;
		}
		if(n>1 && n%1 == 0) {
			return 1+ numDivisors(n,i+1);
		}
		return numDivisors(n,i+1);
	}
	public static int arrSumPos(int[] arr,int i) {
		if(i>=arr.length) {
			return 0;
		}
		if(arr[i]>0) {
			return arr[i] + arrSumPos(arr, i+1);
		}
		return arrSumPos(arr,i+1);
	}
	







}
