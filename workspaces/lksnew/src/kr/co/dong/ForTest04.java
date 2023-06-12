package kr.co.dong;

import java.util.Scanner;

public class ForTest04 {
	public static void main(String[] args) {
//		1부터 입력받은 수 까지 출력
//		단 3의 배수는 출력하지 않는다
		int num = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("input number : ");
		num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
			if (i % 3 != 0) {
				System.out.print(i + " ");
			}
		}
	}
}
