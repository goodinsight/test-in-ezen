package kr.co.dong;

import java.util.Scanner;

public class ForTest10 {
	public static void main(String[] args) {
//		�������� �ܼ��� �̷¹޾Ƽ� ���� ����ϼ���
		Scanner scan = new Scanner(System.in);
		int dan = 0;	// �ܼ�
		int result = 0;		// �����
		
		System.out.print(" �ܼ� �Է� : ");
		dan = scan.nextInt();
		
		System.out.printf("====%d��====%n",dan);
		for (int i = 1; i <= 9; i++) {
			result = dan * i;
			System.out.printf("%d X %d = %d%n", dan, i, result);
		}
		
		System.out.println("========================================");
		
		for (dan = 2; dan <=9; dan++) {
			System.out.printf("====%d��====%n",dan);
			for (int i = 1; i <= 9; i++) {
				result = dan * i;
				System.out.printf("%d X %d = %d ,", dan, i, result);
			}
			System.out.println();
		}
		System.out.println("========================================");
		for (dan = 2; dan <= 9; dan++) {
			System.out.printf("====%d��====\t",dan);
		}
		System.out.println();
		for (int i = 1; i <= 9 ; i++) {
			for (dan = 2; dan <= 9; dan++) {
				result = dan * i;
				System.out.printf("%d X %d = %d\t", dan, i, result);
			}
			System.out.println();
		}
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j<=9; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
}
