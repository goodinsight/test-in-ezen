package kr.co.dong;

import java.util.Scanner;

public class IfTest02 {

	public static void main(String[] args) {
//		���̸� �Է¹޾Ƽ� 20���̸� -> "û�ҳ�"
//		20��~60�� �̸� -> "�߳�"
//		60�� �̻� -> "���" �� �ǰ� ǥ���ϼ���.
		Scanner scan = new Scanner(System.in);
		int age = 0;
		System.out.print("���̸� �Է��ϼ��� : ");
		age = scan.nextInt();
		String result = null; // ����� ����
		if (age < 20) {
			result = "û�ҳ�";
		} else if (age >= 60) {
			result = "���";
		} else {
			result = "�߳�";
		}
		System.out.println("����� ���̴� " + age + "���̰�, " + result + "�Դϴ�.");
	}
}
