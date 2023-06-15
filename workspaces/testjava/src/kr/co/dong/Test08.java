package kr.co.dong;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
//		두 수를 입력받아 큰 수를 출력하시오.
		
		/*
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		
		if (A >= B) {
			System.out.println(A);
		} else {
			System.out.println(B);
		}
		*/
		
//		응용 : 3개 받아서 큰 수 출력
		
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		
		if (A >= B && A >= C) {
			System.out.println(A);
		} else if (B >= A && B >= C) {
			System.out.println(B);
		} else {
			System.out.println(C);
		}
	}

}
