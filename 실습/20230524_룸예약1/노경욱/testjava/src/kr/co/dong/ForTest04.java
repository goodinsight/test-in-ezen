package kr.co.dong;

import java.util.Scanner;

public class ForTest04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1���� �Է¹��� �� ���� ���
//		�� 3�� ����� ������� �ʴ´�.
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���: ");
		int num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
//			System.out.println(i);
			if (i % 3 != 0) {
				System.out.print(i + " ");
			}
		}
	}

}
