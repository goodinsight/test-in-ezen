package kr.co.dong.Array;

import java.util.Scanner;

public class ArrayTest9_1 {

	public static void main(String[] args) {
		// �迭�� dName, dPrice, dAmount ������ ������ 3������ ���Ǳ⸸���.
		
//		1. ����
		boolean power = false;
		
		String [] dName = null;
		int [] dPrice = null;
		int [] dAmount = null;  // ����� ����
		
		int money = 0;             // ���� ��
		int sel = 0;               // ó�� �޴����� 
		int menu = 0;              // ����޴� ����
		int manage = 0;            // �����ڸ�� ����
		
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
			System.out.println("55. �ܵ� ��ȯ   66. ��� Ȯ��   77. �����ڸ��   99. ���� " );
			System.out.println("================================================");
			sel = scan.nextInt();
			
			switch (sel) {
			case 1:    // ���� ������ ��
				System.out.println("���Ḧ ����ּ���.");
				System.out.println("1.�ݶ󱸸�(500��)  2.���̴ٱ���(1000��)  3.ȯŸ����(1500��)");
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
					stock1--;
					break;
				
				case 2:
					System.out.print("�� ���� �־��ּ���. ");
					money = money + scan.nextInt();
					System.out.println("�� ���� ���� �ݾ� : " + money); 
					
					System.out.println(dName[1] + "�� �����Ͽ����ϴ�.");
					System.out.println(dName[1] + "�� ������ " + dPrice[1] + "�� �Դϴ�.");
					System.out.println("���� �ݾ��� : " + (money - dPrice[1]) + "�� �Դϴ�");
					money = money - dPrice[1];
					stock2--;
					break;
	
				case 3:
					System.out.print("�� ���� �־��ּ���. ");
					money = money + scan.nextInt();
					System.out.println("�� ���� ���� �ݾ� : " + money);
					
					System.out.println(dName[2]+"�� �����Ͽ����ϴ�.");
					System.out.println(dName[2]+"�� ������ "+dPrice[2]+"�� �Դϴ�.");
					System.out.println("���� �ݾ��� : "+(money-dPrice[2])+"�� �Դϴ�");
					money = money - dPrice[2];
					stock3--;
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
				System.out.println("> �ݶ��� ���� ����" + dAmount[0] +" �� �Դϴ�.");
				System.out.println("> ���̴��� ���� ����" + dAmount[1] +" �� �Դϴ�.");
				System.out.println("> ȯŸ�� ���� ����" + dAmount[2] +" �� �Դϴ�.");
				break;
				
			case 77:    // ������
				System.out.println("��        ������ ����Դϴ�.        ��");
				System.out.println("��    ���ϴ� �޴��� ��ư�� �����ּ���   ��");
				System.out.println();
				System.out.println("1. ��� ����, 2. ��ǰ ����, 3. ���� ����");
				manage = scan.nextInt();
				
				switch (manage) {
				case 1:
					System.out.println("� ��ǰ�� ��� �����Ͻðڽ��ϱ�?");
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;

				default:
					break;
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