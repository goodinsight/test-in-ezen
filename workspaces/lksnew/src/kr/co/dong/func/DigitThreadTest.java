package kr.co.dong.func;

public class DigitThreadTest {
	public static void main(String[] args) {
		DigitThread d1 = new DigitThread("d1-name");
		DigitThread d2 = new DigitThread("d2-name");
		
		d1.start();
		d2.start();
		
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println("main : "+ ch);
		}
		
		System.out.println("End!!!!");
	}
}
