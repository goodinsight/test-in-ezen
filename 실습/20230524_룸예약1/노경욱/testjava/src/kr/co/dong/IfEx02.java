package kr.co.dong;

import java.util.Scanner;

public class IfEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		int result = 0;
		
		if(a > b && a > c){
			result = a;
		}else if(b > a && b > c){
			result = b;
		}else {
			result = c;
		}
		
		System.out.println("가장 큰 수는: " + result);
	}

}
