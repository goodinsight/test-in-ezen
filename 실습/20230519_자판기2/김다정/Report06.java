package kr.co.dong.CheckPoint;

import java.util.Scanner;

public class Report06 {

	public static void main(String[] args) {
		// �迭�� dName, dPrice, dAmount ������ ������ 3������ ���Ǳ⸸���.
		
//		1. ����
		boolean power = false;
		
		String [] dName = null;
		int [] dPrice = null;
		int [] dAmount = null;     // ����� ����
		
		int money = 0;             // ���� ��
		int sel = 0;               // ó�� �޴����� 
		int menu = 0;              // ����޴� ����
		int manage = 0;            // �����ڸ�� ����
		
		int stock = 0;             // ��� �����ϱ�
		int cokestock = 0;         // 1���ڸ� �����
		int ciderstock = 0;        // 2���ڸ� �����
		int fantastock = 0;        // 3���ڸ� �����
		
		int price = 0;                // ��ǰ ���ݺ����ϱ�
		int cokeprice = 0;            // 1���ڸ� ���ݺ���
		int ciderprice = 0;           // 2���ڸ� ���ݺ���
		int fantaprice = 0;           // 3���ڸ� ���ݺ���
		
		int change = 0;               // ���� ����
		String cokechange = " ";      // 1���ڸ� ���� ����
		String ciderchange = " ";     // 2���ڸ� ���� ����
		String fantachange = " ";     // 3���ڸ� ���� ����

				
//		2. ����
		dName = new String [3];
		dPrice = new int [3];
		dAmount = new int [3];
			
		dName[0] = "�ݶ�";
		dName[1] = "���̴�";
		dName[2] = "ȯŸ";
		
		dPrice[0] = 500;
		dPrice[1] = 1000;
		dPrice[2] = 1500;
		
		dAmount[0] = 10;
		dAmount[1] = 10;
		dAmount[2] = 10;

		Scanner scan = new Scanner(System.in);
		
		while (!power) {
//			1. �� �Է� �ޱ�
			System.out.println("          �� ���ϴ� �޴��� ��ư�� �����ּ���. ��         ");
			System.out.println("=================[  MENU  ]=====================");
			System.out.println("                 1. ���� ����                      ");
			System.out.println("================================================");
			System.out.println("55. �ܵ� ��ȯ          66. ��� Ȯ��         99. ���� " );
			System.out.println("================================================");
			sel = scan.nextInt();
			
			switch (sel) {
			case 1:    // ���� ������ ��
				System.out.println("���Ḧ ����ּ���.");
				System.out.println("1."+dName[0]+"����("+dPrice[0]+"��)  2."+dName[1]+"����("+dPrice[1]+"��)  3."+dName[2]+"����("+dPrice[2]+"��)");
				menu = scan.nextInt();
				
				switch (menu) {
				case 1:
					System.out.print("�� ���� �־��ּ���. ");
					money = money + scan.nextInt();
					System.out.println("�� ���� ���� �ݾ� : " +money);          // ���� �� ǥ��

					System.out.println(dName[0]+"�� �����Ͽ����ϴ�.");
					System.out.println(dName[0]+"�� ������ "+dPrice[0]+"�� �Դϴ�.");
					System.out.println("���� �ݾ��� : "+(money-dPrice[0])+"�� �Դϴ�");
					money = money - dPrice[0];
					dAmount[0]--;
					break;
				
				case 2:
					System.out.print("�� ���� �־��ּ���. ");
					money = money + scan.nextInt();
					System.out.println("�� ���� ���� �ݾ� : " + money); 
					
					System.out.println(dName[1] + "�� �����Ͽ����ϴ�.");
					System.out.println(dName[1] + "�� ������ " + dPrice[1] + "�� �Դϴ�.");
					System.out.println("���� �ݾ��� : " + (money - dPrice[1]) + "�� �Դϴ�");
					money = money - dPrice[1];
					dAmount[1]--;
					break;
	
				case 3:
					System.out.print("�� ���� �־��ּ���. ");
					money = money + scan.nextInt();
					System.out.println("�� ���� ���� �ݾ� : " + money);
					
					System.out.println(dName[2]+"�� �����Ͽ����ϴ�.");
					System.out.println(dName[2]+"�� ������ "+dPrice[2]+"�� �Դϴ�.");
					System.out.println("���� �ݾ��� : "+(money-dPrice[2])+"�� �Դϴ�");
					money = money - dPrice[2];
					dAmount[2]--;
					break;

				default:
					System.out.println("���Ḧ �ٽ� ����ּ���.");
					break;
				}
				break;
				
		    case 55:    // �ܵ� ��ȯ
		    	System.out.println("�ܵ� : "+money+"�� ��ȯ�մϴ�.");
		    	money = 0;
				break;
				
			case 66:    // ���
				System.out.println("> "+dName[0]+"�� ���� ����" + dAmount[0] +" �� �Դϴ�.");
				System.out.println("> "+dName[1]+"�� ���� ����" + dAmount[1] +" �� �Դϴ�.");
				System.out.println("> "+dName[2]+"�� ���� ����" + dAmount[2] +" �� �Դϴ�.");
				break;
				
			case 77:    // ������
				System.out.println("��        ������ ����Դϴ�.        ��");
				System.out.println("��    ���ϴ� �޴��� ��ư�� �����ּ���   ��");
				System.out.println();
				System.out.println("1. ��� ���� ����  2. ��ǰ ���� ����  3. ��ǰ �̸� ����");
				manage = scan.nextInt();
				
				switch (manage) {
				case 1:
					System.out.println("� ��ǰ�� �������� �����Ͻðڽ��ϱ�?");
					System.out.println("1. "+dName[0]+" 2. "+dName[1]+" 3. "+dName[2]);
					stock = scan.nextInt();
					if (stock ==1) {
						System.out.println(dName[0]+"�� �������� �����մϴ�.");
						System.out.println("����� ������ �Է����ּ���.");
						cokestock = scan.nextInt();
						dAmount[0] = cokestock;
						System.out.println("���� "+dName[0]+"�� �������� : "+cokestock+"�� �Դϴ�.");
					}
					else if (stock ==2) {
						System.out.println(dName[1]+"�� �������� �����մϴ�.");
						System.out.println("����� ������ �Է����ּ���.");
						ciderstock = scan.nextInt();
						dAmount[1] = ciderstock;
						System.out.println("���� "+dName[1]+"�� �������� : "+ciderstock+"�� �Դϴ�.");
					}
					else if (stock ==3) {
						System.out.println(dName[2]+"�� �������� �����մϴ�.");
						System.out.println("����� ������ �Է����ּ���.");
						fantastock = scan.nextInt();
						dAmount[2] = fantastock;
						System.out.println("���� "+dName[2]+"�� �������� : "+fantastock+"�� �Դϴ�.");
					}
					break;
				case 2:
					System.out.println("� ��ǰ�� ������ �����ϰڽ��ϱ�?");
					System.out.println("1."+dName[0]+  " 2." +dName[1]+ " 3."+dName[2]);
					price = scan.nextInt();
					if (price ==1) {
						System.out.println(dName[0]+"�� ������ �����մϴ�.");
						System.out.println("���� �� ������ �Է����ּ���.");
						cokeprice = scan.nextInt();
						System.out.println("���� "+dName[0]+"�� ������ : "+cokeprice+"�� �Դϴ�");
						dPrice[0] = cokeprice;
					}
					else if (price ==2) {
						System.out.println(dName[1]+"�� ������ �����մϴ�.");
						System.out.println("���� �� ������ �Է����ּ���.");
						ciderprice = scan.nextInt();
						System.out.println("���� "+dName[1]+"�� ������ : "+ciderprice+"�� �Դϴ�");
						dPrice[1] = ciderprice;
					}
					else if (price ==3) {
						System.out.println(dName[2]+"�� ������ �����մϴ�.");
						System.out.println("���� �� ������ �Է����ּ���.");
						fantaprice = scan.nextInt();
						System.out.println("���� "+dName[2]+"�� ������ : "+fantaprice+"�� �Դϴ�");
						dPrice[2] = fantaprice;
					}
					break;
				case 3:
					System.out.println("� ��ǰ�� �����ϰڽ��ϱ�?");
					System.out.println("1."+dName[0]+  " 2." +dName[1]+ " 3."+dName[2]);
					change = scan.nextInt();
					if (change ==1) {
						System.out.println(dName[0]+"�� ��ǰ�̸��� �����մϴ�.");
						System.out.println("���� �� ��ǰ�̸��� �Է����ּ���.");
						cokechange = scan.next();
						System.out.println(dName[0]+"�� "+cokechange+"�� ����Ǿ����ϴ�.");
						dName[0] = cokechange;
						dAmount[0] = 0;
						System.out.println("��� ����Ȯ������ ���� ��� �־��ּ���. ");
					}
					else if (change ==2) {
						System.out.println(dName[1]+"�� ��ǰ�̸��� �����մϴ�.");
						System.out.println("���� �� ��ǰ�̸��� �Է����ּ���.");
						ciderchange = scan.next();
						System.out.println(dName[1]+"�� "+ciderchange+"�� ����Ǿ����ϴ�.");
						dName[1] = ciderchange;
						dAmount[1] = 0;
						System.out.println("��� ����Ȯ������ ���� ��� �־��ּ���. ");
					}
					if (change ==3) {
						System.out.println(dName[2]+"�� ��ǰ�̸��� �����մϴ�.");
						System.out.println("���� �� ��ǰ�̸��� �Է����ּ���.");
						fantachange = scan.next();
						System.out.println(dName[2]+"�� "+fantachange+"�� ����Ǿ����ϴ�.");
						dName[2] = fantachange;
						dAmount[2] = 0;
						System.out.println("��� ����Ȯ������ ���� ��� �־��ּ���. ");
					}
				}
				
				break;
				
			case 99:   // ����
				power = true;
				System.out.println("�ý����� �����մϴ�.");
				break;
				
			default:
				System.out.println("�߸��� �����Դϴ�.");
				break;
			}
	
		}
	}
}