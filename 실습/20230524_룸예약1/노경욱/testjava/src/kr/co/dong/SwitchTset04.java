package kr.co.dong;

import java.util.Scanner;

public class SwitchTset04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		if������ ó���� ����ó���� switch������ ó���غ���
//		��: �� ���� ���� �ܿ� ������ �����ϼ���
		int score = 0;
		Scanner scan = new Scanner(System.in);
		char grade = 'x';
		char buho = '0';
		
		System.out.print("�����Է�: ");
		score = scan.nextInt();
		
		switch(score / 10) {
		case 10: case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';
			break;
		}
		
		System.out.println("����: " + grade);
		
	}

}
