package kr.co.dong;

import java.util.Scanner;

public class Report04 {

	public static void main(String[] args) {
//		1. ���� ���Ǳ� ����
//		2. ���� 3���� ���� / ���� / ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1.  ������ ������ ����,  ����, �Ž����� ��ȯ, �� �Է� ��~
//		      99. ���Ǳ� ����
//		4. 99�̿��� ������ ��� ȭ�� �޴� �����ֱ�
		
		boolean power = false; // ����
//		�޴��Է�, ���� ��, �����̸�1,2,3, ,����1,2,3 ,�Ž��� ��
		int sel =0; //�޴� ����
		int money = 0;
		Scanner scan = new Scanner(System.in);
		
		String name1 = "���̴�" ;
		String name2 = "�ݶ�";
		String name3 = "����";
		
		int sprit = 1000;
		int coke = 1000;
		int zero = 1200;  //�޴� �̸� & ����
		
		
		while(!power) { 
//			0. �� �Է�
		    System.out.println("���Աݾ� : ");
		    money = money + scan.nextInt(); // �̷����ؾ� �Աݵ� �ݾ��� ���� ��.scan.nextInt�� ������ �ݾ� ���� x
		    
//			1. �޴� �����ֱ�
			
			System.out.println("============ [ Menu ] ============");
			System.out.println("1. ���̴�(1000) 2. �ݶ�(1000) 3. ����(1200)");
			System.out.println("5. �Ž����� ��ȯ 99. ����");
			System.out.println("���� �Աݾ� : " + money);
			
//			2. �޴�����
//			sane.next(); �ϸ� ������ �ݾױ��� �����°� Ȯ�� ����
			System.out.println("select number : ");
			sel = scan.nextInt();
//			3. ���ÿ� ���� �б�
			switch(sel) {
			case 1 : // ���̴� ����
					System.out.println("���̴�");			
				break;
			case 2 : // �ݶ� ����
				System.out.println("�ݶ�");
				break;
			case 3 : // ���� ����
				System.out.println("����");
				break;
			case 5 : // �Ž��� �� ��ȯ
				if(sprit<=money) {
					System.out.println("�Ž����� : " + (sprit-money));
				} else if(coke<=money) {
					System.out.println("�Ž����� : " + (coke-money));
				} else if(zero<=money) {
					System.out.println("�Ž����� : " + (zero-money));
				}else {
					System.out.println("�ݾ��� �����մϴ�");
				}
							
			case 99 : // ����
				power = true;
				System.out.println("�ý��� �ƿ�");
				break;
				default :
					System.out.println("�߸��� �����Դϴ�. �ٽ� �����ϼ���.");
				
			}
		}
		System.out.println("�����Ǳ� �����");
	}

}

