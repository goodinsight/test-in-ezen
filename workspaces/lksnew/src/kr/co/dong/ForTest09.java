package kr.co.dong;

import java.util.Scanner;

public class ForTest09 {
	public static void main(String[] args) {
//		시작값과 마지막 값을 입력받는다.
//		그 합을 구한다. (그 사이 값의 합을 구한다.)
//		추가 : 짝수의 합 구해보기
		int start = 0, end = 0, sum = 0, evenSum = 0;

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("시작값 : ");
			start = scan.nextInt();
			System.out.print("마지막값 : ");
			end = scan.nextInt();

			if (start < end) {
				break;
			}
			System.out.println("시작값이 마지막값보다 작도록 다시 입력하세요");
		}

		for (int i = start; i <= end; i++) {
			sum += i;
			if (i % 2 != 1) {
				evenSum += i;
			}
		}

		System.out.printf("%d에서 %d까지의 합: %d%n", start, end, sum);
		System.out.printf("%d에서 %d까지의 짝수의 합: %d", start, end, evenSum);
	}
}
