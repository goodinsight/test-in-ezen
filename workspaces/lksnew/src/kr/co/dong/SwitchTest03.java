package kr.co.dong;

import java.util.Random;
import java.util.Scanner;

public class SwitchTest03 {
	public static void main(String[] args) {
		
//		����ڿ��� 1(����), 2(����), 3(��)�� �Է¹ް�
//		��ǻ�ʹ� ������ ��(1~3) ������ ���� �޾Ƽ�
//		������� �¸����θ� ����ϴ� ���α׷��� �ۼ��ϼ���
		int userNum = 0;
		int comNum = 0;
		String result = null;
		String comValue = null;
		String userValue = null;
		
		����������:
		while(true) {
			�Էº�:
			while(true) {
				Scanner scan = new Scanner(System.in);
				System.out.print("����(�Ǵ� 1), ����(�Ǵ� 2), ��(�Ǵ� 3) �� �ϳ��� �Է�, �׸��Ͻ÷��� (0)�� �Է��ϼ���: ");
				userValue = scan.next();
				comNum = (int)(Math.random()*3 + 1);
				switch (comNum) {
				case 1:
					comValue = "����" ;
					break;
				case 2:
					comValue = "����" ;
					break;
				case 3:
					comValue = "��" ;
					break;
				}
				switch (userValue) {
				case "1": case "����":
					userValue = "����" ;
					userNum = 1;
					result = whoIsWin(userNum, comNum);
					break �Էº�;
				case "2": case "����":
					userValue = "����" ;
					userNum = 2;
					result = whoIsWin(userNum, comNum);
					break �Էº�;
				case "3": case "��":
					userValue = "��" ;
					userNum = 3;
					result = whoIsWin(userNum, comNum);
					break �Էº�;
				case "0":
					break ����������;
				default:
					System.out.println("�ٽ� �Է��ϼ���.");
					break ;
				}
			}
			System.out.println("����� "+ userValue +"�̰�, ��ǻ�ʹ� " + comValue + "�Դϴ�. ��ǻ�Ϳ��� ����� " + result+ " �Դϴ�.");
		}
	}

	private static String whoIsWin(int a, int b) {
		String result = null;
		if (a - b == 1 || a - b == -2) {
			result = "�¸�";
		} else if (a - b == -1 || a - b == 2) {
			result = "�й�";
		} else if (a - b == 0) {
			result = "���";
		}
		return result;
	}
}
