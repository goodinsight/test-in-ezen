package JaPanGi;

import java.util.Scanner;

public class Report22 {

	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������
//		2. ���� 3���� ���� / ���� ���� / ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�
//		3-1. ������ ������ ����, ����, �Ž����� ��ȯ, �� �Է� ��
//			99. ���Ǳ� ����
//		4. 99 �̿��� ������ ��� ȭ��޴� �����ֱ�
		
		boolean power = false; // ����
//		�޴��Է°�, ���� ��, �����̸�123, ����123 , �Ž�����
		
		int menu = 0; // �޴� �Է°�
		int money = 0; // ���� ��
		int total_input = 0; // ���� �� �հ�
		int sel = 0; // �޴� ����
		String name1 = "�ݶ�";
		String name2 = "���̴�";
		String name3 = "�������꽺";
		int price1 = 500;
		int price2 = 1200;
		int price3 = 2500;
		
		
		Scanner scan = new Scanner(System.in);
		
		while(!power) {
			// 0. �� �Է�
			System.out.print("���� �ݾ� : ");
			money = money + scan.nextInt(); // money ���� ��Ű��
			
//			 1. �޴� �����ֱ�
			 System.out.println("====== [ menu ] ========");
			 System.out.println("1. �ݶ�(500��) 2. ���̴�(1200��) 3. �������꽺(2500��)");
			 System.out.println("5. �Ž����� ��ȯ 99. ����");
			 System.out.println("���� �Աݾ� : "+money);
			 
//			 2. �޴� ����
			 System.out.print("Select : ");
			 sel = scan.nextInt();
//			3. ���ÿ� ���� �б�
			 switch (sel) {
				case 1: // �ݶ� ���ý�
					System.out.println("�ݶ� ����");
					break;
				case 2: // ���̴� ���ý�
					System.out.println("���̴� ����");
					break;
				case 3: // �������꽺 ���ý�
					System.out.println("�������꽺 ����");
					break;
				case 5: // �Ž����� ��ȯ
					System.out.println("�Ž����� ��ȯ��");
					break;
				case 99:
					power = true;
					System.out.println("�ý��� �ƿ�!");
					break;
	
				default:
					break;
				}
			 
			 
			 
			 
		}
		
		System.out.println("���Ǳ� ����!!");

	}

}
