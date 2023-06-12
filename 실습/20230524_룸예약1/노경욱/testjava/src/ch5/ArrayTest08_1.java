package ch5;

import java.util.Scanner;

public class ArrayTest08_1 {
	public static void main(String[] args) {
//		입력받은 수만큼 로또 생성하기
		final int NUM = 6;
		int[][] lotto = null; // 선언
		int count = 0;

		System.out.print("몇장을 구매? ");
		Scanner scan = new Scanner(System.in);
		count = scan.nextInt();

		lotto = new int[count][NUM];

//		번호받기
		for (int n = 0; n < count; n++) {
			for (int i = 0; i < NUM; i++) {
				lotto[n][i] = (int) (Math.random() * 45) + 1;
				for (int j = 0; j < i; j++) {
					if (lotto[n][i] == lotto[n][j]) {
						i--; // n번째 배열에 중복이 있으면 for문에 i값을 줄여서 다시시도
					}
				}
			}
		}
//		번호들 출력
		for (int n = 0; n < count; n++) {
			System.out.println("==============================");
			for (int i = 0; i < NUM; i++) {
				System.out.print(lotto[n][i]+ ", ");
			}
			System.out.println();
		}
	}
}
