package da_5_15;

import java.util.Scanner;

public class Report13 {

	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������
//		2. ���� 3���� / ���� ���� / ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1 ������ ������ ���� , ����, �Ž����� ��ȯ, ���Է� ��
//			99. ���Ǳ� ����
//		4. 99�̿��� ������ ��� ȭ��޴� �����ֱ�
		boolean power = false;	//����
//		�޴��Է°�, ���� ��, �����̸�1,2,3 ����1,2,3 , �Ž��� ��
		Scanner scan = new Scanner(System.in);
		String drink1 = "�Ƹ޸�ī��";
		String drink2 = "��ũĿ��";
		String drink3 = "�ͽ�Ŀ��";
		int price1 = 700, price2 = 600, price3 = 500;
		int change = 0;
		int money = 0;
		while(!power) {
			System.out.print("���� ����\n1.�Ƹ޸�ī��(700) - 2.��ũĿ��(600) - 3.�ͽ�Ŀ��(500)");
			System.out.println("\n���� �־��");
			money = money + scan.nextInt();
			System.out.println("1��,2��,3�� �� ����");
			int choice = scan.nextInt();
			if(choice == 1) {
				if(money >= price1) {
					change = money - price1;
					System.out.println("�Ž�����" + change+"��");
				}else if(money < price1){
					System.out.println("������ �� :"+ (price1 - money+"��"));
				}
				System.out.println(drink1 +"700��");
		
			}
			else if(choice == 2) {
				if(money >= price2) {	
					change = money - price2;
					System.out.println("�Ž�����" + change+"��");
				}else {
					System.out.println("������ �� :"+ (price2 - money+"��"));
				}
				System.out.println(drink2 + "600��");
		
			}
			else if(choice == 3) {
				if(money >= price3) {
					change = money - price3;
					System.out.println("�Ž�����" + change+"��");
				}else {
					System.out.println("������ �� :"+ (price3 - money+"��"));
				}
				System.out.println(drink3 + "500��");
			}
			if(choice == 99) {
				power = true;
			}
		}
		
		
		System.out.println("���Ǳ� ����!!");
		
		

	}

}
