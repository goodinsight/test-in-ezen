package kr.co.dong;

import java.util.Scanner;

public class ForTest10 {
	public static void main(String[] args) {
//		구구단의 단수를 이력받아서 곱을 출력하세요
		Scanner scan = new Scanner(System.in);
		int dan = 0;	// 단수
		int result = 0;		// 결과값
		
		System.out.print(" 단수 입력 : ");
		dan = scan.nextInt();
		
		System.out.printf("====%d단====%n",dan);
		for (int i = 1; i <= 9; i++) {
			result = dan * i;
			System.out.printf("%d X %d = %d%n", dan, i, result);
		}
		
		System.out.println("========================================");
		
		for (dan = 2; dan <=9; dan++) {
			System.out.printf("====%d단====%n",dan);
			for (int i = 1; i <= 9; i++) {
				result = dan * i;
				System.out.printf("%d X %d = %d ,", dan, i, result);
			}
			System.out.println();
		}
		System.out.println("========================================");
		for (dan = 2; dan <= 9; dan++) {
			System.out.printf("====%d단====\t",dan);
		}
		System.out.println();
		for (int i = 1; i <= 9 ; i++) {
			for (dan = 2; dan <= 9; dan++) {
				result = dan * i;
				System.out.printf("%d X %d = %d\t", dan, i, result);
			}
			System.out.println();
		}
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j<=9; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
}
