package kr.co.dong;

import java.util.Scanner;

public class Report20 {

	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������
//		2. ���� 3���� ���� / ���� ���� / ����
//		3. ���۰� ���ÿ� �޴��� �����ش�.
//		3-1 	1. ������ ���� �� ���� , ���� , �Ž����� ��ȯ, ���Է� ��
//				99. ���Ǳ� ����
//				4. 99�̿��� ������ ��� ȭ��޴� �����ֱ�

		boolean power = false; // ����
//		�޴��Է�, ��, �����̸�1,2,3, ����1,2,3, �Ž�����	
		int menu = 0; // (�޴�)
//		String d1 ="�ݶ�";	
//		String d2 ="���̴�";
//		String d3 ="����";	// ��������
//		String msg =" ";
		int money = 0; // ��
		int price = 0; // ����
		int m1 = 300, m2 = 500, m3 = 200;
		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.println("=====================");
			System.out.println("    ���� �������ּ���!   ");
			System.out.println("=====================");
			money = money + scan.nextInt();
			System.out.println("�޴��� ���ÿ� ");
			System.out.println("1. �ݶ�(1000) 2. ��������Ʈ(1200) 3. ���� ���̴�(1500) ");
			System.out.println("99 ���� ");
			System.out.println("���� �Աݾ� " + money);

			menu = scan.nextInt();

			switch (menu) {
			case 1:
				price = m1;
				System.out.println("�ݶ� �����ϼ̽��ϴ�. ");
				if (money < price)
					System.out.println("���� �����մϴ�.");
				break;
				
			case 2:
				price = m2;
				System.out.println("��������Ʈ�� �����ϼ̽��ϴ�. ");
				if (money < price)
					System.out.println("���� �����մϴ�.");
				break;
				
			case 3:
				
				price = m3;
				System.out.println("���� ���̴ٸ� �����ϼ̽��ϴ�. "); 
				if (money < price)
					System.out.println("���� �����մϴ�.");
				break;
				
			case 99:
				power = true;
				System.out.println("���Ǳ� ����!!");
				break;
				
			default:
				System.out.println(" �ش� �޴��� �����ϴ�.");
				break;
			}

		}

	}

}
