package kr.co.dong;

import java.util.Scanner;

public class WhileTest03 {
	public static void main(String[] args) {
//		���� 32563 �� �Է¹޾Ƽ� �� �ڸ����� ���� ���ϼ���.
		int num = 0, sum = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("input integer: ");
		num = scan.nextInt();
//		�Է�
		
//		ó��
		
//		���
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		System.out.println("�� �ڸ����� ��: " + sum);
	}
	
}
