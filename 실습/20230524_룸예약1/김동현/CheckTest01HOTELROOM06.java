package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest01HOTELROOM06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��12���� �ִ� ����?�迭? �迭�� room[12]
		// �޴������� 1,2,3,99�� �з¹���
		// 1�� ������ ���� ������
		// ȣ�ǹ�ȣ ����(1~12) +>������¿��θ� �R������
		// ���డ�ɻ��� ->����ǽ�->ȣ�� �R�� => �޴�����
		// ����Ұ��� ȣ�ǹ�ȣ�� ���� �Ǵ� �޴��� ������
		// 2�� ������� �������(����->����) ���ȣ�� 0�̸� ����
		// 3�� �������� ȣ��Ȯ�� , 1�̸� ����Ȱ��� 0�̸� ���డ���ϴ�
		// 99�� ������ ��������
		Scanner scan = new Scanner(System.in);

		int[] room = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };// 12���� ��ȣ����
		boolean power = false;
		int menu;// �޴� 1 ,2 ,3 ,99

		int num1;//���ȣ , ȣ�� 0�Ǵ� 1 �� �������ִ�?!?!?!?!

		while (!power) {//���� �Ŀ��� ����Ǵ� ���� ���ϵ幮�� �����ϴ�
			System.out.println("�������ξ�Կ����Ͻǰǰ���?");
			System.out.println("1. �濹��");
			System.out.println("2. �������");
			System.out.println("3. ȣ��Ȯ���մϴ�");
			System.out.println("99.�ý��������մϴ�");
			System.out.println("��ȣ�� �Է����ּ���");
			menu = scan.nextInt();//�޴� ���� ����
			switch (menu) {
			case 1:// ����������������???���̺���հ�, �������ڽ��� �վ����
				System.out.println("���ȣ�� �Է��ϼ���");
				num1 = scan.nextInt();
				if (room[num1 - 1] == 0) {
					room[num1 - 1] = 1;// �������
				} else if (room[num1 - 1] == 1) {
					System.out.println("�̹̿���ȹ��Դϴ�");
				}
				break;
			case 2:// ������� , ���� �� ��Ұ��� ���� ���
				System.out.println("��ҿ� ���鿩�θ� Ȯ��");
				System.out.println("���ȣ�� �Է��ϼ���");
				num1 = scan.nextInt();
				if (room[num1 - 1] == 1) {//0�� 1�� �Ǵܰ� ��°� ������ ����
					room[num1 - 1] = 0;
				} else if (room[num1 - 1] == 0) {//0�̸� ������NONO����
					System.out.println("�����̾ȵȹ��Դϴ�");
				}
				break;
			case 3:
				for (int i = 0; i < room.length; i++) {
					if (room[i] == 1) {
						System.out.println(i + 1 + "�� �� : ����� ");
					} else if (room[i] == 0) {//0�̸� ���డ������
						System.out.println(i + 1 + "���� : ���డ���մϴ�");
					}
				}
				break;
			case 99://�ص� �Ŀ��� ����
				power=true;
				System.out.println("END");
			default:
				break;
			}
		}
	}

}
