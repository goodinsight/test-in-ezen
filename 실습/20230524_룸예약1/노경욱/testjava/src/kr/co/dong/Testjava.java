package kr.co.dong;

import java.util.Scanner;

public class Testjava {

	public static void main(String[] args) {
		// �� ������ �ַܼ� �Է� ����ͷ� ���
		//����κ�: �ڷ���Ÿ�� + ������
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
//		�ܼ� ȣ���Ͽ� ����ϱ� : Scanner Ŭ����
		Scanner scan = null; //������
		
//		����ϱ�
		scan = new Scanner(System.in);
		
//		num1�� �ְܼ� �Է��ϱ�
		System.out.print("num1 �����Է�: ");
		num1 = scan.nextInt();
		
//		num1 ���
		System.out.println(num1);
		
//		num2�� �ְܼ� �Է��ϱ�
		System.out.print("num2 �����Է�: ");
		num2 = scan.nextInt();
		
//		num2 ���
		System.out.println(num2);
		
//		num1�� �ְܼ� �Է��ϱ�
		System.out.print("num3 �����Է�: ");
		num3 = scan.nextInt();
		
//		num1 ���
		System.out.println(num3);
	}

}
