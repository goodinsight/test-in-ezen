package kr.co.dong;

import java.util.Scanner;

public class ForTest04 {
	public static void main(String[] args) {
//		1���� �Է¹��� �� ���� ���
//		�� 3�� ����� ������� �ʴ´�
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
