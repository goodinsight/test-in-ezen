/*
 * 1���� �ֻ��� ���ڸ� �ַܼ� �Է¹޾Ƽ� "������ �ֻ����� 0 �Դϴ�"�� ����ϱ�
 */
package kr.co.dong;

import java.util.Scanner;

public class IfTest03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dice = -1;
		String result = null;
		System.out.print("�ֻ��� ���ڸ� �Է�(1~6) : ");
		dice = scan.nextInt();
		if (dice == 1) {
			result = "1";
		} else if (dice == 2) {
			result = "2";
		} else if (dice == 3) {
			result = "3";
		} else if (dice == 4) {
			result = "4";
		} else if (dice == 5) {
			result = "5";
		} else if (dice == 6) {
			result = "6";
		} else {
			System.out.println("������ ��?!?!");
		}
		System.out.println("������ �ֻ����� " + result + "�Դϴ�.");		
	}
}
