package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report_01_6 {
	public static void main(String[] args) {

		boolean power = false; // ���Ǳ� ����ġ

		String drink1 = "�ݶ�"; // ��ǰ �̸�
		String drink2 = "���̴�";
		String drink3 = "ȯŸ";

		int value1 = 100; // ��ǰ ����
		int value2 = 200;
		int value3 = 300;

		int inCoin = 0; // �Է°��� �ִ� ��
		int inputMenu = 0; // �޴� �Է�
		int count = 0; // ó������ �ּҰ��� �˸� ���߿� �̰���

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.printf(" ------------------- Menu ------------------ \n");
			System.out.printf(" 1. �����ֱ�\t80. ȯ��(�ܾ�ã��)    99. ����\n");
			System.out.printf("11. %s(%d��) 12. %s(%d��)  13. %s(%d��)\n", drink1, value1, drink2, value2, drink3, value3);
			
			System.out.print("Select : ");
			inputMenu = scan.nextInt();

			switch (inputMenu) {
			case 1: // �����ֱ�
				count++;
				if (count == 1)
					System.out.printf("�ּ� ���Աݾ��� 100�� �Դϴ�. \n");
				else
					System.out.printf(" \n");

				while (true) {
					System.out.printf("������ �־� �ּ���.> \n");
					inCoin = inCoin + scan.nextInt();
					if (inCoin >= 100) {
						System.out.printf("���� �ܾ��� %d �Դϴ�. \n", inCoin);
						System.out.println("�����Ͻ� �ܾ����� ���԰����� �Ʒ� �޴��� ������ �ּ���.>");
						System.out.println("ȯ���� ����>80  ��Ҵ� >  99�� �����ּ���");
						break;
					} // end of if �ּұݾ�
					else {
						System.out.printf("������ �����մϴ�. �� �־� �ּ��� �����ܾ� = %d \n", inCoin);
					} // end of else
				}
				break;

			case 11: // ��ǰ1
				if (inCoin >= value1) {
					System.out.printf("\n%s�� �ϴ� ���ⱸ�� �ֽ��ϴ�. �����մϴ�. \n", drink1);
					inCoin = inCoin - value1;
					System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);
				} else {
					System.out.println("�ܾ��� �����մϴ�. ==> 1. �����ֱ⸦ �����ּ���");
					break;
				}
				break;

			case 12: // ��ǰ2
				if (inCoin >= value2) {
					System.out.printf("\n%s�� �ϴ� ���ⱸ�� �ֽ��ϴ�. �����մϴ�. \n", drink2);
					inCoin = inCoin - value2;
					System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);
				} else {
					System.out.println("�ܾ��� �����մϴ�. ==> 1. �����ֱ⸦ �����ּ���");
					break;
				}
				break;

			case 13: // ��ǰ3
				if (inCoin >= value3) {
					System.out.printf("\n%s�� �ϴ� ���ⱸ�� �ֽ��ϴ�. �����մϴ�. \n", drink3);
					inCoin = inCoin - value3;
					System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);
				} else {
					System.out.println("�ܾ��� �����մϴ�. ==> 1. �����ֱ⸦ �����ּ���");
					break;
				}
				break;

			case 80: // ȯ��
				if (inCoin > 0) {
//					�Ž����� ì��� -> 5õ��1�� õ��?�� ������� 
					
					System.out.printf("�ܾ� %d�� ì�ܰ�����. �����մϴ�. \n ", inCoin);
					inCoin = 0;
					System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);
					inCoin = 0;
				} else {
					System.out.println("�����帱 �ܾ��� �����ϴ�. �����մϴ�. \n ");
					System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);
				}
				break;
			case 99: // ������ ����
				power = true;
				break;
			default:
				System.out.println(" �۵��� ������ �߻��Ͽ����ϴ�. �ٽ� ���� ��Ź�帳�ϴ�.");
				break;
			} // end of case

		} // end of while
		System.out.println("���Ǳ� �Ǹ� ����. ������ �ǿ�����~~~~");
	} // end of main
} // end of class
