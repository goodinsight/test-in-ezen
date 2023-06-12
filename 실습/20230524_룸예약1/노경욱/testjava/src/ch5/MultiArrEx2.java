package ch5;

import java.util.Scanner;

public class MultiArrEx2 {

	public static void main(String[] args) {

		final int SIZE = 5;
		int x = 0, y = 0, num = 0;
		int[][] bingo = new int[SIZE][SIZE];
		Scanner scanner = new Scanner(System.in);

//		배열의 모든 요소를 1부터 SIZE * SIZE까지의 숫자로 초기화
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				bingo[i][j] = SIZE * i + (j + 1);
			}
		}
		
//		배열에 저장된 값을 뒤섞는다
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				x = (int) (Math.random() * SIZE);
				y = (int) (Math.random() * SIZE);

				int tmp = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = tmp;

			}
		}

		do {
			for (int i = 0; i < bingo.length; i++) {
				for (int j = 0; j < bingo[i].length; j++) {
					System.out.printf("%2d ", bingo[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			System.out.printf("1~%d의 숫자를 입력하세요. (종료: 0) > ", SIZE * SIZE);
			num = scanner.nextInt(); //입력받은 문자열을 int로 저장
			
//			입력받은 숫자와 같은 숫자가 있으면 0으로 만듦
			outer: for (int i = 0; i < bingo.length; i++) {
				for (int j = 0; j < bingo[i].length; j++) {
					if (num == bingo[i][j]) {
						bingo[i][j] = 0;
						break outer;
					}
				}
			}

		} while (num != 0);
		System.out.println("게임을 종료합니다.");
	}

}
