package kr.co.dong;

import java.util.Scanner;

public class IfEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		int result = 0;
		
		if((a > b && a < c) || (a > c && a < b)) {
			result = a;
		}else if((b > a && b < c) || (b > c && b < a)) {
			result = b;
		}else {
			result = c;
		}
		
		System.out.println("두번째로 큰 수는: " + result);
	}

}
