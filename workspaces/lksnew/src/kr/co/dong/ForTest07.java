package kr.co.dong;

import java.util.Scanner;

public class ForTest07 {
	public static void main(String[] args) {
//		1���� �Է¹��� �� ������ �ձ��ϱ�
		int num = 0;
		int sum = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("input number: ");
		num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
			System.out.print(i);
			sum += i;
			if (i != num) {
				System.out.print(" + ");
			}
		}
		System.out.println(" = " + sum);
		
	}
}
