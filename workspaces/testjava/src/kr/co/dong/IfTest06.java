package kr.co.dong;

import java.util.Scanner;

public class IfTest06 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int score = -1;
		char grade = 'x';
		char sign = 'x';

		while (true) {
			System.out.print("������ �Է��ϼ��� : ");
			score = scan.nextInt();
			if (score == 100) {
				grade = 'A';
				sign = '+';
			} else if (score >= 60 && score < 100) {
				grade = (char) (74 - score / 10);
				if (score % 10 >= 7) {
					sign = '+';
				} else if (score % 10 < 3) {
					sign = '-';
				} else {
					sign = ' ';
				}
			} else if (score >= 0 && score < 60) {
				grade = 'F';
				sign = ' ';
			} else {
				System.out.println("������ �߸� �Է��ϼ̽��ϴ�.(0~100)");
				continue;
			}
			break;
		}
		System.out.print("����� ������ " + score + "���̰�, ������ " + grade + sign + "�Դϴ�.");
	}
}
