package kr.co.dong;

import java.util.Scanner;

public class ForTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		�ַܼ� �Է¹��� ������ ����غ���
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���: ");
		int num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
//			System.out.println(i);
			System.out.print(i + " ");
		}
	}

}
