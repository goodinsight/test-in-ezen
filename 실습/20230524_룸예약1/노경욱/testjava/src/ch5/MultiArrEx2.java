package ch5;

import java.util.Scanner;

public class MultiArrEx2 {

	public static void main(String[] args) {

		final int SIZE = 5;
		int x = 0, y = 0, num = 0;
		int[][] bingo = new int[SIZE][SIZE];
		Scanner scanner = new Scanner(System.in);

//		�迭�� ��� ��Ҹ� 1���� SIZE * SIZE������ ���ڷ� �ʱ�ȭ
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				bingo[i][j] = SIZE * i + (j + 1);
			}
		}
		
//		�迭�� ����� ���� �ڼ��´�
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
			System.out.printf("1~%d�� ���ڸ� �Է��ϼ���. (����: 0) > ", SIZE * SIZE);
			num = scanner.nextInt(); //�Է¹��� ���ڿ��� int�� ����
			
//			�Է¹��� ���ڿ� ���� ���ڰ� ������ 0���� ����
			outer: for (int i = 0; i < bingo.length; i++) {
				for (int j = 0; j < bingo[i].length; j++) {
					if (num == bingo[i][j]) {
						bingo[i][j] = 0;
						break outer;
					}
				}
			}

		} while (num != 0);
		System.out.println("������ �����մϴ�.");
	}

}
