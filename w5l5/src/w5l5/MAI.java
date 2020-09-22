package w5l5;

public class MAI {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
				System.out.println(hypen("daniel"));
				System.out.println(getBracketL("RicHarD"));
				System.out.println(remUpper("RicHarD"));
				System.out.println(undSecond("balls"));
				System.out.println(sumOdd(123456789));
		}

		public static String hypen(String s) {
			if (s.length() <= 0) {
				return s;
			}
			return s.charAt(0) + "_" + hypen(s.substring(1));
		}
		public static String getCaps(String s) {
			if(s.length()<= 0) {
				return s;
			}
			if(s.charAt(0)<='Z'&&s.charAt(0)>='A') {
				return s.charAt(0)+getCaps(s.substring(1));
			}
		return getCaps(s.substring(1));
		}
		
		public static String getBracketL(String s) {
			if (s.length() <= 0) {
				return s;
			}
			char a = s.charAt(0);
			if(a>='a'&&a<='z') {
				return "[" + a + "]" + getBracketL(s.substring(1));
			}
			return a+getBracketL(s.substring(1));
		}
		
		public static String remUpper(String s) {
			if(s.length()<=0) {
				return s;
			}
			char a = s.charAt(0);
			if(a>='A'&&a<='Z') {
				return remUpper(s.substring(1));
			}
			return a + remUpper(s.substring(1));
		}
		
		public static String undSecond(String s) {
			if(s.length()<=2) {
				return s;
			}
			return s.substring(0,2) + "__" + undSecond(s.substring(2));
		}
		public static int sumOdd(int n) {
			if(n<=0) {
				return 0;
			}
			if(n%2 == 1) {
				return n%10 + sumOdd(n/10);
			}
			return sumOdd(n/10);
		}
		public static int prodEven(int n) {
			if(n<=0) {
				return 1;
			}
			if(n%2 == 0) {
				return n%10 * prodEven(n/10);
			}
			return prodEven(n/10);
		}
		public static boolean isPrime(int n, int i) {
			if(i>n/2) {
				return true;
			}if(i>1&&n%i == 0) {
				return false;
			}
			return isPrime(n,i+1);
		}
		public static String remLower(String s) {
			if(s.length()<=0) {
				return s;
			}
			char a = s.charAt(0);
			if(a>='a'&&a<='z') {
				return remLower(s.substring(1));
			}
			return s.charAt(0)+ remLower(s.substring(1));
		}

	}

