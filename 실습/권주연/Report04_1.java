package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report04_1 {

	public static void main(String[] args) {
//		1. ���� ���Ǳ� ����
//		2. ���� 3���� ���� / ���� / ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1.  ������ ������ ����,  ����, �Ž����� ��ȯ, �� �Է� ��~
//		      99. ���Ǳ� ����
//		4. 99�̿��� ������ ��� ȭ�� �޴� �����ֱ�

		boolean power = false; // ����
//		�޴��Է�, ���� ��, �����̸�1,2,3, ,����1,2,3 ,�Ž��� ��
		int sel = 0; // �޴� ����
		int money = 0;
		Scanner scan = new Scanner(System.in);

		String name1 = "���̴�";
		String name2 = "�ݶ�";
		String name3 = "����";

		int sprit = 1000;
		int coke = 1000;
		int zero = 1200; // �޴� �̸� & ����

		while (!power) {
//			
//			1. �޴� �����ֱ�

			System.out.println("============ [ Menu ] ============");
			System.out.println("1. ���̴�(1000) 2. �ݶ�(1000) 3. ����(1200)");
			System.out.println("4. �ݾ� �����ϱ� 5. �Ž����� ��ȯ 99. ����");
			System.out.println("���� �Աݾ� : " + money);

//			2. �޴�����
//			sane.next(); �ϸ� ������ �ݾױ��� �����°� Ȯ�� ����
			System.out.println("select number : ");
			sel = scan.nextInt();
//			3. ���ÿ� ���� �б�
			switch (sel) {
			case 1: // ���̴� ����
				System.out.println("���̴�");
				break;
			case 2: // �ݶ� ����
				System.out.println("�ݶ�");
				break;
			case 3: // ���� ����
				System.out.println("����");
				break;
			case 4:
//				0. �� �Է�
				System.out.print("�ݾ��� �����ϼ��� ==>  ");
				money = money + scan.nextInt(); // �̷����ؾ� �Աݵ� �ݾ��� ���� ��.scan.nextInt�� ������ �ݾ� ���� x
				break;
			case 5: // �Ž��� �� ��ȯ

				System.out.println("�Ž����� : " + money +"���� ��ȯ�Ǿ����ϴ�.");
				money = 0;
				break;

			case 99: // ����
				power = true;
				System.out.println("�ý��� �ƿ�");
				break;
			default:
				System.out.println("�߸��� �����Դϴ�. �ٽ� �����ϼ���.");

			}
		}
		System.out.println("�����Ǳ� �����");
	}

}
