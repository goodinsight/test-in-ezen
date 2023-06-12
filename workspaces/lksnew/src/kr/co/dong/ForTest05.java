package kr.co.dong;

import java.util.Scanner;

public class ForTest05 {
	public static void main(String[] args) {
//		시작값과 마지막값을 입력받는다
//		그 안의 모든 홀수를 출력한다.
		int start = 0;
		int end = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("시작값: ");
		start = scan.nextInt();
		System.out.print("마지막값: ");
		end = scan.nextInt();

		for (int i = start; i <= end; i++) {
			if (i%2 !=0) {
				System.out.print(i + " ");
			}
		}
	}
}
