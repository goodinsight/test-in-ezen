/*
 * Ctrl + Spacebar : ����
 */
package kr.co.dong;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		// �� ������ �ַܼ� �Է¹޾Ƽ� ����Ϳ� ���
		// ����κ� : �ڷ���Ÿ�� + ������
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		// �ܼ� ȣ���Ͽ� ����ϱ� : Scanner Ŭ����
		Scanner scan = null; // ������
		// ����ϱ�
		scan = new Scanner(System.in);
		
//		num1�� �ְܼ� �Է��ϱ�
		System.out.print("ù��° �����Է� : ");
		num1 = scan.nextInt();
		System.out.print("�ι�° �����Է� : ");
		num2 = scan.nextInt();
		System.out.print("����° �����Է� : ");
		num3 = scan.nextInt();
//		num1 ���
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}

}
