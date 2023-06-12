package ch5;

import java.util.Scanner;

public class ArrayTest08_1 {
	public static void main(String[] args) {
//		�Է¹��� ����ŭ �ζ� �����ϱ�
		final int NUM = 6;
		int[][] lotto = null; // ����
		int count = 0;

		System.out.print("������ ����? ");
		Scanner scan = new Scanner(System.in);
		count = scan.nextInt();

		lotto = new int[count][NUM];

//		��ȣ�ޱ�
		for (int n = 0; n < count; n++) {
			for (int i = 0; i < NUM; i++) {
				lotto[n][i] = (int) (Math.random() * 45) + 1;
				for (int j = 0; j < i; j++) {
					if (lotto[n][i] == lotto[n][j]) {
						i--; // n��° �迭�� �ߺ��� ������ for���� i���� �ٿ��� �ٽýõ�
					}
				}
			}
		}
//		��ȣ�� ���
		for (int n = 0; n < count; n++) {
			System.out.println("==============================");
			for (int i = 0; i < NUM; i++) {
				System.out.print(lotto[n][i]+ ", ");
			}
			System.out.println();
		}
	}
}
