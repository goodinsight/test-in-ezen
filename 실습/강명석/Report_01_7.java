package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report_01_7 {
	public static void main(String[] args) {

		boolean power = false; // ���Ǳ� ����ġ

		String drink1 = "�ݶ�"; // ��ǰ �̸�
		String drink2 = "���̴�";
		String drink3 = "ȯŸ";

		int value1 = 100; // ��ǰ ����
		int value2 = 200;
		int value3 = 300;
		
		int count1 = 2;  // ��ǰ ����
		int count2 = 2;
		int count3 = 2;
		
		int money1 = 100; // 100�� ����
		int money2 = 500; // 500�� ����
		int money3 = 1000; // 1000�� ����
		
		int sumMoney1 = 1000; // 100�� �ܷ�
		int sumMoney2 = 1000; // 500�� �ܷ�
		int sumMoney3 = 1000; // 1000�� �ܷ�	
		int totalMoney = 0;    // ���Ǳ� �Ѿ�

		int inCoin = 0; // �Է°��� �ִ� ��
		int jandon = 0; // ȯ���� �ܵ�Ȯ��
		int inputMenu = 0; // �޴� �Է�
		int count = 0; // ó������ �ּҰ��� �˸� ���߿� �̰���

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.printf(" ----------------------------- Menu ---------------------------- \n");
			System.out.printf(" 1. �����ֱ�\n");
			// ��� ���� �޴�����
			System.out.printf("11. %s(%d��)(�ܷ�%d) 12. %s(%d��)(�ܷ�%d)  13. %s(%d��)(�ܷ�%d)\n", drink1, value1, count1, drink2, value2, count2, drink3, value3, count3);
			System.out.println();
			System.out.println("80. ȯ��(�ܾ�ã��)            99. ����                 90. ������ ���");
			System.out.printf(" --------------------------------------------------------------- \n");
			
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
					
					if(inCoin<500) { // �� �ݾ׺� ����
						sumMoney1 = sumMoney1 + inCoin;						
					}
					else if(inCoin >=500 && inCoin <1000) {
						sumMoney2 = sumMoney2 + inCoin;
					}
					else if(inCoin >=1000) {
						sumMoney3 = sumMoney3 + inCoin;
					}
					// ���� ���� �Է� ���� if, else if	
					
					
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
				if(count1>0) { // ��ǰ1 ���Ž� ��� ������ ��� ���� �˸���, �ܾ� �� �޴� �˸�
					if (inCoin >= value1) {
						System.out.printf("\n%s�� �ϴ� ���ⱸ�� �ֽ��ϴ�. �����մϴ�. \n", drink1);
						inCoin = inCoin - value1;
						count1 = count1 - 1;
						System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);
					} else {
						System.out.println("�ܾ��� �����մϴ�. ==> 1. �����ֱ⸦ �����ּ���");
						break;
					}
				} // end of if ��� ������ case11
				else {
					System.out.println("��� �����ϴ�. �ٸ� �޴� ������ �ּ���. \n");
					System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);
				} // end of else ��� ���� �� case11
				break;

			case 12: // ��ǰ2
				if(count2>0) { // ��ǰ2 ���Ž� ��� ������ ��� ���� �˸���, �ܾ� �� �޴� �˸�
					if (inCoin >= value2) {
						System.out.printf("\n%s�� �ϴ� ���ⱸ�� �ֽ��ϴ�. �����մϴ�. \n", drink2);
						inCoin = inCoin - value2;
						count2 = count2 - 1;
						System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);
					} else {
						System.out.println("�ܾ��� �����մϴ�. ==> 1. �����ֱ⸦ �����ּ���");
						break;
					}
				} // end of if ��� ������ case12
				else {
					System.out.println("��� �����ϴ�. �ٸ� �޴� ������ �ּ���. \n");
					System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);					
				} // end of else ��� ���� �� case12
				break;

			case 13: // ��ǰ3
				if(count3>0) { // ��ǰ3 ���Ž� ��� ������ ��� ���� �˸���, �ܾ� �� �޴� �˸�
					if (inCoin >= value3) {
						System.out.printf("\n%s�� �ϴ� ���ⱸ�� �ֽ��ϴ�. �����մϴ�. \n", drink3);
						inCoin = inCoin - value3;
						count3 = count3 - 1;
						System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);
					} else {
						System.out.println("�ܾ��� �����մϴ�. ==> 1. �����ֱ⸦ �����ּ���");
						break;
					}
				} // end of if ��� ������ case13
				else {
					System.out.println("��� �����ϴ�. �ٸ� �޴� ������ �ּ���. \n");
					System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);									
				} // end of else ��� ���� �� case13
				break;

			case 80: // ȯ��
				if (inCoin > 0) {
//					�Ž����� ì��� -> 1õ��1�� 500�� 100�� 
					System.out.printf("\n �ܾ� %d�� ì�ܰ�����. �����մϴ�. \n ", inCoin);
					jandon = (inCoin%10000/1000);					
					System.out.printf("õ�� %d ���� ���ɴϴ�.\n", jandon);
						sumMoney3 = sumMoney3 - 1000*jandon;
					jandon = (inCoin%1000/500);					
					System.out.printf("����� %d ���� ���ɴϴ�.", jandon);
						sumMoney2 = sumMoney2 - 500*jandon;
					jandon = (inCoin-500)%1000/100;
					System.out.printf(" ��� %d ���� ���ɴϴ�.\n", jandon);	
						sumMoney1 = sumMoney1 - 100*jandon;
					
					inCoin = 0;
					System.out.printf("\n�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);
				} else {
					System.out.println("�����帱 �ܾ��� �����ϴ�. �����մϴ�. \n ");
					System.out.printf("�ܾ��� %d �Դϴ�. \n�߰��Ա�(1), �ܾ�ã��(80), ����(99)�� �����ּ��� \n\n", inCoin);
					inCoin = 0;
				}
				break;
				
			case 90: // ������ ��� ��ǰ �ܷ� Ȯ�� �� �Ž����� �ܷ� Ȯ��
				System.out.println("------------��� Ȯ��----------- \n");
				System.out.printf("��ǰ �ܷ��� %s = %d��, %s = %d, %s = %d�� �Դϴ�. \n", drink1, count1, drink2, count2, drink3, count3);
				System.out.println("------------�Ž����� Ȯ��--------- \n");
				totalMoney = sumMoney1 + sumMoney2 + sumMoney3;
				System.out.printf("���Ǳ� ��ü �ݾ� : %5d \n", totalMoney);
				System.out.printf("1000�� �Ž����� : %5d, %d�� ���ҽ��ϴ�. \n", sumMoney3, sumMoney3/1000 );
				System.out.printf(" 500�� �Ž����� : %5d, %d�� ���ҽ��ϴ�. \n", sumMoney2, sumMoney2/500 );
				System.out.printf(" 100�� �Ž����� : %5d, %d�� ���ҽ��ϴ�. \n", sumMoney1, sumMoney1/100 );

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
