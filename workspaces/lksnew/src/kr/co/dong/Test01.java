package kr.co.dong;

public class Test01 {

	static public void  main(String args[]) {

	    char ch = 'A';
		char lowerCase = ('A'<=ch && ch<='Z') ? (char)(ch+32) : ch;
		System.out.println(lowerCase);
		
	
		System.out.println("1" + "2");
		System.out.println("");
		System.out.println(true);
		
		System.out.println('A' + 'B');
		System.out.println('1' + 2);
		System.out.println('1' + '2');
		System.out.println('J' + "ava");
//		System.out.println(true + null);
		System.out.println("" + null);

		
		
	}

}
