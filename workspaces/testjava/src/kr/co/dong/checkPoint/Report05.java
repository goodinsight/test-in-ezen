package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report05 {

	public static void main(String[] args) {
//		 ���Ǳ� �����
		
		boolean power = false;     //����
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;   // �޴�����
		int money = 0;
		int change = 0;
		
		String name1 = "ȯŸ";       //�޴� �̸�
		String name2 = "���̴�";
		String name3 = "�����ݶ�";
		
		int price1 = 1000;
		int price2 = 1200;
		int price3 = 1500;
		
		
		while(!power) {
//			0. �޴� �����ֱ�
			System.out.println("==================[ Menu ]=======================");
			System.out.println("��   1. ȯŸ(1000) 2. ���̴�(1200) 3. �����ݶ�(1500)   ��");
			System.out.println("=================================================");
			System.out.println("=================================================");
			System.out.println("��       5. �Ž����� ��ȯ        99. ����             ��");
			System.out.println("=================================================");
			
//			1. ���Է�
			System.out.print("������ �ݾע� : ");
			money = money + scan.nextInt();          //�׳� �Է¸� �ް� money +�� �����ָ� ���� �ݾ׿� ���� ������ �ȵȴ�.
			
			System.out.println("������ �Աݾע� : " + money);
			
//			2. �޴�����
			System.out.print("�޴��� �������ּ���. : ");
			menu = scan.nextInt();
			
//			3. ���ÿ� ���� �б�
			switch (menu) {
			case 1:   // ȯŸ ���ý�
				System.out.println("> ȯŸ!");
				System.out.println("> �ܵ� ��ȯ �Ͻðڽ��ϱ�? (��ȯ�� 5���� �����ּ���)");
				menu = scan.nextInt();
				break;
				
			case 2:   // ���̴� ���ý�
				System.out.println("> ���̴�!");
				System.out.println("> �ܵ� ��ȯ �Ͻðڽ��ϱ�? (��ȯ�� 5���� �����ּ���)");
				menu = scan.nextInt();
				break;
				
			case 3:   // �����ݶ� ���ý�
				System.out.println("> �����ݶ�!");
				System.out.println("> �ܵ� ��ȯ �Ͻðڽ��ϱ�? (��ȯ�� 5���� �����ּ���)");
				menu = scan.nextInt();
				break;
				
			case 5:   // �Ž����� ��ȯ
				System.out.println("�Ž����� : ");
				switch (change) {
				case 1:
					
					break;

				default:
					break;
				}
				break;
			case 99:  // ����
				power = true;
				System.out.println("�ý����� �����մϴ�.");
				break;
			default:
				System.out.println("�߸��� �����Դϴ�.");
			}
			}
		}
}

