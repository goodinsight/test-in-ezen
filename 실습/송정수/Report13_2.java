package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report13_2 {

	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������
//		2. ���� 3���� / ���� ���� / ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1 ������ ������ ���� , ����, �Ž����� ��ȯ, ���Է� ��
//			99. ���Ǳ� ����
//		4. 99�̿��� ������ ��� ȭ��޴� �����ֱ�
		boolean power = false; // ����
//		�޴��Է°�, ���� ��, �����̸�1,2,3 ����1,2,3 , �Ž��� ��
		Scanner scan = new Scanner(System.in);
		String drink1 = "�Ƹ޸�ī��"; // �����̸� 1
		String drink2 = "��ũĿ��"; // �����̸� 2
		String drink3 = "�ͽ�Ŀ��"; // �����̸� 3
		String slot = " ";	//�ٲ� ���� �̸�
		int price1 = 700, price2 = 600, price3 = 500; // ���� ����
		int cprice = 0;		//���� ���� ���� �ݾ�
		int change = 100000; // �Ž�����
		int money = 0; // ��
		int choice = 0; // �޴��Է°�
		int plus = 0; // ���� ä���
		int plusM= 0;	//�� ä���
		int remain1 = 1, remain2 = 1, remain3 = 1; // ����
		while (!power) {
//			1. �޴�
			System.out.println("[�޴�]");
			System.out.printf("1.�� �Ա� 2.%s %d�� 3.%s %d�� 4.%s 2%d��",drink1,price1,drink2,price2,drink3,price3);
			System.out.println("\n5.�Ž����� 99.���Ǳ� ����");
			System.out.print("�����ϱ� : ");
			choice = scan.nextInt();
//			2.��ư
			switch (choice) {
			case 1:
				System.out.println("����");
				money = money + scan.nextInt();
				System.out.println("�ܾ� : " + money + "��");
				break;
			case 2:
				System.out.println("���� : " + remain1);
				if (remain1 == 0) {
					System.out.println("������ ���� �Ф�");
				}
				if (money < price1) {
					System.out.println("�� ���� " + (price1 - money) + "��");
					System.out.println("�� ����");
				}
				if (money >= price1 && remain1 > 0) {
					System.out.println("�Ƹ޸�ī��");
					money = money - price1;
					remain1 = remain1 - 1;
					System.out.println("���� : " + remain1);
				}
				break;
			case 3:
				System.out.println("���� : " + remain2);
				if (remain2 == 0) {
					System.out.println("������ ����Ф�");
				}
				if (money < price2) {
					System.out.println("�� ���� " + (price2 - money) + "��");
					System.out.println("�� ����");
				}
				if (money >= price2 && remain2 > 0) {
					System.out.println("��ũĿ��");
					money = money - price2;
					remain2--;
					System.out.println("���� : " + remain2);
				}
				break;
			case 4:
				System.out.println("���� : " + remain3);
				if (remain3 == 0) {
					System.out.println("������ ����Ф�");
				}
				if (money < price3) {
					System.out.println("�� ���� " + (price3 - money) + "��");
					System.out.println("�� ����");
				}
				if (money >= price3 && remain3 > 0) {
					System.out.println("�ͽ�Ŀ��");
					money = money - price3;
					remain3--;
					System.out.println("���� : " + remain3);
				}
				break;
			case 5:
				System.out.println(money + "��");
				if(change >= money) {					
				change = change - money;
				money = 0;
				}
				if(change < money) {
					System.out.println("�ܵ��� �����ؼ� �ȳ��߾��. ���������� ��ȭ���ּ���");
				}
				break;
			case 77:
				System.out.println("������ ���");
				System.out.println("��ȣ ����");
				System.out.println("1.��� ä��� 2.�Ž����� ä��� 3.���� ���ݺ��� 4.�޴� ����");
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.printf("ä�� ���Ǽ��� : 1.%s 2.%s 3.%s",drink1,drink2,drink3);
					choice = scan.nextInt();
					System.out.print("ä�� ���� : ");
					plus = scan.nextInt();
					switch (choice) {
					case 1:
						System.out.println("���� ���� : " + remain1);
						remain1 = remain1 + plus;
						System.out.println("���� ���� : " + remain1);
						break;
					case 2:
						System.out.println("���� ���� : " + remain2);
						remain2 = remain2 + plus;
						System.out.println("���� ���� : " + remain2);
						break;
					case 3:
						System.out.println("���� ���� : " + remain3);
						remain3 = remain3 + plus;
						System.out.println("���� ���� : " + remain3);
						break;
					}
					break;
				case 2:
					System.out.print("�󸶸� ä�ﲸ? : ");
					plusM = scan.nextInt();
					change = change + plusM;
					System.out.println(change + "��");
					break;
				case 3:
					System.out.printf("�ٲ� ���� ���� : 1.%s 2.%s 3.%s",drink1,drink2,drink3);
					choice = scan.nextInt();
					System.out.print("�ٲ� ���� ���� �Է� : ");
					cprice = scan.nextInt();
					switch(choice) {
					case 1:
						price1 = cprice;
						System.out.printf("%s ���� - %d%n",drink1,price1);
						break;
					case 2:
						price2 = cprice;
						System.out.printf("%s ���� - %d%n",drink2,price2);
						break;
					case 3:
						price3 = cprice;
						System.out.printf("%s ���� - %d%n",drink3,price3);
						break;
					}
					break;
				case 4:
					System.out.printf("�ٲ� ���� ���� : 1.%s 2.%s 3.%s",drink1,drink2,drink3);
					choice = scan.nextInt();
					System.out.print("�ٲ� ���� �̸� �Է� : ");
					slot = scan.next();
					switch(choice) {
					case 1:
						System.out.printf("%s -> %s%n",drink1,slot);
						drink1 = slot;
						break;
					case 2:
						System.out.printf("%s -> %s%n",drink2,slot);
						drink2 = slot;
						break;
					case 3:
						System.out.printf("%s -> %s%n",drink3,slot);
						drink3 = slot;
						break;
					}

				}
				break;
				case 99:
					power = true;
					break;
				default:
					System.out.println("���� - �ٽ� �����Ͻÿ�.");
			}

		}
		System.out.println("���Ǳ� ����!!");


	}
}