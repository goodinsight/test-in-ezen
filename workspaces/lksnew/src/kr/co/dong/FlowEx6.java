package kr.co.dong;

import java.util.Scanner;

public class FlowEx6 {
	public static void main(String[] args) {
//	���� ���� �Է¹޾Ƽ� 3,4,5 ->'��' 6,7,8 -> '����'
//		9,10,11 ->'����' 12, 1, 2 ->'�ܿ�'
	
		int month = 0;
		String season = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("���� ���� �Է��ϼ���: ");
		month = scan.nextInt();
		
		switch (month) {
		case 3:
		case 4:
		case 5:
			season = "��";
			break;
		case 6:
		case 7:
		case 8:
			season = "����";
			break;
		case 9:
		case 10:
		case 11:
			season = "����";
			break;
		case 12:
		case 1:
		case 2:
			season = "�ܿ�";
			break;
		default:
			System.out.println("���� ���� �ٽ� �Է��ϼ���.");
			break;
		}
		System.out.println("���� ������ " + season + "�Դϴ�.");
	}
}