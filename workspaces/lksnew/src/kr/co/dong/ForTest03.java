package kr.co.dong;

import java.util.Scanner;

public class ForTest03 {
	public static void main(String[] args) {
//		1���� �ַܼ� �Է¹��� ������ ����غ���
		int num = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		num = scan.nextInt();
		
		for (int i = 1; i <= num; i++) {
			System.out.print(i + " ");
		}
	}
}
