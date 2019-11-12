
public class NumberWordConvertor {
	
	static final String numberWord[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	static final String tenWord[] = {"ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
	static final String afterTenWord[] = {"eleven","tweleve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","ninteen"};
	static final String arr[] = {"hundred","thousand","billion","milion"};
	
	static void convertNumberToWord(String number) {
		int len = number.length();
		if(len == 3 ) {
			printhundredNumber(number);
		} else if (len > 3 && len <= 5) {
			printThousandNumber(number);
		} else if (len > 5 && len <= 7) {
			printBillionNumber(number);
		} else if (len > 7) {
			printMillionNumber(number);
		} else if(len == 1) {
			System.out.println(checkOneNumber(Integer.parseInt(number)));
		} else {
			if(!"".equals(checkAfterTenNumber(Integer.parseInt(number))))
				System.out.println(checkAfterTenNumber(Integer.parseInt(number)));
			else {
				printTenNumber(number);
			}
		}
	}
	
	
	static void printTenNumber(String number) {
		if(!"".equals(checkAfterTenNumber(Integer.parseInt(number))))
			System.out.println(" "+checkAfterTenNumber(Integer.parseInt(number)));
		else {
		char c = number.charAt(0);
		int n = Integer.parseInt(String.valueOf(c));
		if(tenWord[0].equals(checkTenNumber(n))) {
			System.out.print(" "+checkTenNumber(n));
		} else {
			System.out.print(" "+checkTenNumber(n));
			c = number.charAt(1);
			n = Integer.parseInt(String.valueOf(c));
			System.out.print(" "+checkOneNumber(n));
		}
		}
	}
	
	static void printhundredNumber(String number) {
		char c = number.charAt(0);
		int n = Integer.parseInt(String.valueOf(c));
		if(!"".equals(checkOneNumber(n)))
			System.out.print(" "+checkOneNumber(n)+" "+ arr[0]);
		printTenNumber(number.substring(1));
	}
	
	static void printThousandNumber(String number) {
		int len = number.length();
		if(len == 5) {
			char c = number.charAt(0);
			int n = Integer.parseInt(String.valueOf(c));
			if(!"".equals(checkTenNumber(n)))
				System.out.print(" "+checkTenNumber(n)+" "+ arr[1]);
			printhundredNumber(number.substring(2));
		} else if (len == 4) {
			char c = number.charAt(0);
			int n = Integer.parseInt(String.valueOf(c));
			if(!"".equals(checkOneNumber(n)))
				System.out.print(" "+checkOneNumber(n)+" "+ arr[1]);
			printhundredNumber(number.substring(1));
		}
	}
	
	static void printBillionNumber(String number) {
		int len = number.length();
		if(len == 7) {
			char c = number.charAt(0);
			int n = Integer.parseInt(String.valueOf(c));
			if(!"".equals(checkTenNumber(n)))
				System.out.print(" " +checkTenNumber(n)+" "+ arr[2]);
			printThousandNumber(number.substring(2));
		} else if (len == 6 ) {
			char c = number.charAt(0);
			int n = Integer.parseInt(String.valueOf(c));
			if(!"".equals(checkOneNumber(n)))
				System.out.print(checkOneNumber(n)+" "+ arr[2]);
			printThousandNumber(number.substring(1));
		}
	}
	
	static void printMillionNumber(String number) {
		int len = number.length();
		convertNumberToWord(number.substring(0,(len-6)));
		System.out.print(" "+arr[3]+" ");
		printMillionNumber(number.substring((len-6)));
	}
	
	public static void main(String a[]) {
		convertNumberToWord("1111");
	}
	
	static String checkOneNumber(int n) {
	 String ans= "";
		switch(n)	{
			case 0 : break;
			case 1 : ans = numberWord[1]; break;
			case 2 : ans = numberWord[2]; break;
			case 3 : ans = numberWord[3]; break;
			case 4 : ans = numberWord[4]; break;
			case 5 : ans = numberWord[5]; break;
			case 6 : ans = numberWord[6]; break;
			case 7 : ans = numberWord[7]; break;
			case 8 : ans = numberWord[8]; break;
			case 9 : ans = numberWord[9]; break;
	 }
		return ans;
	}
	
	static String checkTenNumber(int n) {
		 String ans= "";
			switch(n)	{
				case 1 : ans = tenWord[0]; break;
				case 2 : ans = tenWord[1]; break;
				case 3 : ans = tenWord[2]; break;
				case 4 : ans = tenWord[3]; break;
				case 5 : ans = tenWord[4]; break;
				case 6 : ans = tenWord[5]; break;
				case 7 : ans = tenWord[6]; break;
				case 8 : ans = tenWord[7]; break;
				case 9 : ans = tenWord[8]; break;
		 }
			return ans;
		}
	
	static String checkAfterTenNumber(int n) {
		 String ans= "";
			switch(n)	{
				case 11 : ans = afterTenWord[0]; break;
				case 12 : ans = afterTenWord[1]; break;
				case 13 : ans = afterTenWord[2]; break;
				case 14 : ans = afterTenWord[3]; break;
				case 15 : ans = afterTenWord[4]; break;
				case 16 : ans = afterTenWord[5]; break;
				case 17 : ans = afterTenWord[6]; break;
				case 18 : ans = afterTenWord[7]; break;
				case 19 : ans = afterTenWord[8]; break;
		 }
			return ans;
		}

}
