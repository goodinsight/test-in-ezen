package kr.co.dong;

import java.util.Scanner;

public class WhileTest03 {
	public static void main(String[] args) {
//		정수 32563 를 입력받아서 각 자리수의 합을 구하세요.
		int num = 0, sum = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("input integer: ");
		num = scan.nextInt();
//		입력
		
//		처리
		
//		출력
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		System.out.println("각 자리수의 합: " + sum);
	}
	
}
