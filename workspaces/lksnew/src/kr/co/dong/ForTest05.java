package kr.co.dong;

import java.util.Scanner;

public class ForTest05 {
	public static void main(String[] args) {
//		���۰��� ���������� �Է¹޴´�
//		�� ���� ��� Ȧ���� ����Ѵ�.
		int start = 0;
		int end = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("���۰�: ");
		start = scan.nextInt();
		System.out.print("��������: ");
		end = scan.nextInt();

		for (int i = start; i <= end; i++) {
			if (i%2 !=0) {
				System.out.print(i + " ");
			}
		}
	}
}
