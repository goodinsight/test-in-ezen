package kr.co.dong.Report;

import java.util.Scanner;

public class Report05 {

	public static void main(String[] args) {
//		���Ǳ� 
//		1. �������Ǳ⸦ ��������
//		2. ���� 3���� ���� / ���� ���� / ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1. ������ ������ ����, ����, �Ž����� ��ȯ, ���Է� ��
//		   99. ���Ǳ� ����
//		4. 99�̿��� ������ ��� ȭ��޴� �����ֱ�.
		
		boolean power = false;     // ����
//		�޴��Է°�, ���� ��, �����̸� 1,2,3, ���� 1,2,3, �Ž�����
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		int money = 0;
		int change = 0;
		int price1 = 1000, price2 = 2000, price3 = 3000;
		
		
//		price[1��] = �̸� ���� : "�ݶ�"
//		price[2��] = �̸� ���� : "���̴�"	
//		price[3��] = �̸� ���� : "ȯŸ"
		
		while(!power) {
			System.out.println("��ǰ�� �������ּ���.");
			System.out.println("1. �ݶ� (1000��), 2. ���̴�(2000��), 3. ȯŸ(3000��)");
			menu = scan.nextInt();
			
			System.out.println("���� �־��ּ���.");
			money = scan.nextInt();
			
			if (menu == 1) {
				if (money >= price1) {
					System.out.println("�ݶ� ���ɴϴ�.");
					if (money > price1) {
						System.out.println("�ܵ��� ��ȯ�մϴ�. ");
						System.out.println("�ܵ��� "+(money-price1)+"�Դϴ�");
				}else {
					System.out.println("���� �� ��������.");
				}break;
			}
			}
			
			else if (menu == 2) {
				if (money >= price2) {
					System.out.println("���̴ٰ� ���ɴϴ�.");
					if (money > price2) {
						System.out.println("�ܵ��� ��ȯ�մϴ�. ");
						System.out.println("�ܵ��� "+(money-price2)+"�Դϴ�");
				}else {
					System.out.println("���� �� ��������.");
				}break;
			}
			}
			
			else if (menu == 3){
				if (money >= price3) {
					System.out.println("ȯŸ�� ���ɴϴ�.");
					if (money > price3) {
						System.out.println("�ܵ��� ��ȯ�մϴ�. ");
						System.out.println("�ܵ��� "+(money-price3)+"�Դϴ�");
				}else {
					System.out.println("���� �� ��������.");
				}break;
			}
			}
			
			else if (menu == 99) {
				System.out.println("���Ǳ� ����!!");
				break;
			}
		}
		
	}
}
	
		
			


