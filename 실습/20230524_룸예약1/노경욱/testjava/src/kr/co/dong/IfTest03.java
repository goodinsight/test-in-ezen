/*
 * 1���� �ֻ��� ���ڸ� �ַܼ� �Է¹޾Ƽ� "������ �ֻ����� 0 �Դϴ�"�� ����ϱ�
 */
package kr.co.dong;

import java.util.Scanner;

public class IfTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		
		System.out.print("�ֻ��� ���ڸ� �Է��Ͻÿ�: ");
		Scanner input = new Scanner(System.in);
		num = input.nextInt();
		
		if (num == 1) {
			System.out.println("������ �ֻ����� 1�Դϴ�.");			
		}else if(num == 2) {
			System.out.println("������ �ֻ����� 2�Դϴ�.");
		}else if(num == 3) {
			System.out.println("������ �ֻ����� 3�Դϴ�.");
		}else if(num == 4) {
			System.out.println("������ �ֻ����� 4�Դϴ�.");
		}else if(num == 5) {
			System.out.println("������ �ֻ����� 5�Դϴ�.");
		}else if(num == 6) {
			System.out.println("������ �ֻ����� 6�Դϴ�.");
		}else {
			System.out.println("�ֻ����� �̻��մϴ�.");
		}
		
	}

}
