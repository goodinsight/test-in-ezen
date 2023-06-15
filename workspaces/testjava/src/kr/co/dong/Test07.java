package kr.co.dong;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
//		세 정수 A, B, C가 주어진다
//		이때, 두번째로 큰 정수를 출력하는 프로그램을 작성하시오.
		
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		
		if (A >= B && A >= C) {
			if (B >= C) {
				System.out.println(B);
			} else {
				System.out.println(C);
			}
		} else if (B >= C) {
			if (A >= C) {
				System.out.println(A);
			} else {
				System.out.println(C);
			}
		} else {
			if (A >= B) {
				System.out.println(A);
			} else {
				System.out.println(B);
			}
		}
	}

}
