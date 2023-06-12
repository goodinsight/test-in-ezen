package kr.co.dong;

import java.util.Scanner;

public class ForTest04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1부터 입력받은 수 까지 출력
//		단 3의 배수는 출력하지 않는다.
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
//			System.out.println(i);
			if (i % 3 != 0) {
				System.out.print(i + " ");
			}
		}
	}

}
