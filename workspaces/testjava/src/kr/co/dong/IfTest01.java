/*
 * �� ������ �ܼ��Է� �޾Ƽ� ū���� ����ϼ���
 */
package kr.co.dong;

import java.util.Scanner;

public class IfTest01 {
	public static void main(String[] args) {
//		����
		int num1 = 0, num2 = 0;
		Scanner scan = new Scanner(System.in);

//		�Է�
		System.out.print("First Number : ");
		num1 = scan.nextInt();
		System.out.print("Second Number : ");
		num2 = scan.nextInt();
		
//		ó�� : ū ���� ã��
		if (num1 > num2) {
			System.out.println("ū ���� : " + num1);
		}
		else if (num2 > num1) {
			System.out.println("ū ���� : " + num2);
		}
		else {
			System.out.println("�� ���� �����ϴ�.");
		}
		System.out.println("Program END!!!");
	}
}
