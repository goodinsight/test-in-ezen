package kr.co.dong;

import java.util.Scanner;

public class IfTeset07 {

	public static void main(String[] args) {
//		������ �Է¹޾Ƽ� 90�̻��̸� ������ A, 80�̻��̸� B
//		70�̻��̸� C, 60�̻��̸� D, 60�̸��̸� F �� ����ϼ���
//		
//		�߰�����1 : 97�̻��̸� A+ 93�̸��̸� A-
//		�߰�����2 : 87�̻��̸� A+ 83�̸��̸� A-
//		�߰�����3 : 77�̻��̸� A+ 73�̸��̸� A-
//		�߰�����4 : 67�̻��̸� A+ 63�̸��̸� A-
//		�����ϼ���.
				
		Scanner scan = new Scanner(System.in);
		int score = -1;
		char grade = 'x';
		char sign = 'x';

		System.out.print("������ �Է��ϼ��� : ");
		score = scan.nextInt();
		if (score >= 90) {
			grade = 'A';

		} else if (score >= 80) {
			grade = 'B';

		} else if (score >= 70) {
			grade = 'C';

		} else if (score >= 60) {
			grade = 'D';

		} else {
			grade = 'F';
		}
		if (score >= 60) {
			if(score % 10 >= 7 || score == 100) {
				sign = '+';
			} else if(score % 10 < 3) {
				sign = '-';
			} else {
				sign = ' ';
			}
		} else {
			sign = ' ';
		}
		
		System.out.print("����� ������ "+ score +"���̰�, ������ "+ grade + sign +"�Դϴ�.");
	}
}