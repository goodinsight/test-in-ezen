package kr.co.dong;

import java.util.Scanner;

public class ForTest10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		�������� �ܼ��� �Է¹޾Ƽ� ���� ����ϼ���
		Scanner scan = new Scanner(System.in);
		int dan = 0; // �ܼ�
		int result = 0; // �����

		System.out.print("�ܼ��Է�: ");
		dan = scan.nextInt();

		for (int i = 1; i <= 9; i++) {
			result = i * dan;
			System.out.println(dan + " x " + i + " = " + result);
		}
		System.out.println("=============================");
		
		for (dan = 2; dan<=9;dan++) {
			System.out.println("["+dan + "��"+"]");
			for(int i = 1 ; i <= 9; i++) {
				result = dan * i;
				System.out.println(dan + " x " + i + " = " + result);
			}
		}
	}	

}
