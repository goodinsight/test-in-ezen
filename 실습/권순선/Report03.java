package kss.co.kr;

import java.util.Scanner;

public class Report03 {
	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������
//		2. ���� 3���� ���� / ���� ���� / ��� ��
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�
//		3-1. ������ ���� ����, ��� ��, �Ž����� ��ȯ, ���Է�
//			 99. ���Ǳ� ����
//		4. 99�̿��� ������ ��� ȭ��޴� �����ֱ�

		boolean power = false; // ����
//		�޴��Է�, ���� ��, �����̸�1,2,3 , ����1,2,3 , �ܵ�
		int menu = 0;
		int money = 0;
		int coin = 0;

		String a = "���̴�";
		String b = "Ŀ��";
		String c = "�����ݶ�";

		int moneya = 1000;
		int moneyb = 1500;
		int moneyc = 2000;

		Scanner sc = new Scanner(System.in);

		while (!power) {

			System.out.print("�� >>>>> ");
			money += sc.nextInt();
			System.out.println(money);
			
			System.out.println("�޴� ����");
			System.out.println("1) ���̴� 3000��, 2) Ŀ�� 3500��, 3) �ݶ� 2000��, 5) �ܵ�, 99) ����");
			System.out.println("���� �Աݾ� " + money);
			
			System.out.print("�޴� >>>>> ");
			menu = sc.nextInt();

			switch (menu) {
			
			case 1:
				System.out.println("���̴�");
				break;

			case 2:
				System.out.println("Ŀ��");

				break;

			case 3:
				System.out.println("�ݶ�");

				break;
				
			case 5:
				System.out.println("�ܵ�");
				
				break;

			case 99:
				power = true;
				System.out.println("�ܵ� " + money);
				break;

			default:
				System.out.println("�ٽ� �Է�");
				break;
			}

		}
		System.out.println("���Ǳ� ����");

	}

}