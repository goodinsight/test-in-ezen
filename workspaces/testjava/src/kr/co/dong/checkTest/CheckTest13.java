package kr.co.dong.checkTest;

import java.util.Arrays;
import java.util.Scanner;

public class CheckTest13 {
	public static void main(String[] args) {
//		Ű���忡 ���� �Է��ۼ�
//		��12���� �ְ� =>����?�迭? => �迭 ����room[12]
//		�Է±�������	//menu����:1,2,3,99�� �Է¹���
//		1�� �������� ���� ����,	//room[���ȣ]�� ���� 1�̸� �������
//			1->ȣ�ǹ�ȣ ����(1~12) -> ������¿��� Ȯ��
//		->���డ�ɻ��� -> ����ǽ� ->ȣ��Ȯ�� => �޴��� ����
//		2�� ���� ��� �������(����->����),	//room[���ȣ]�� ���� 0�̸� ����
//				2-> ȣ�ǹ�ȣ����(1~12)->��Ұ��ɿ���
//			->��Ұ���: �ش�ȣ���� ���� 0���� =>�޴�����
//			->��ҺҰ�: ����������� ���̶�� ǥ��. =>�޴�����
//		3�� ���� ���� ȣ�� Ȯ��,	//1�� ���� "�����:��"0�ΰ��� "���డ�ɡ�"
//		99�� ���� ���� ���α׷�����.
		boolean power = false; // ���α׷� ����
		int[] reserve = new int[12]; // ���� �� ����
		int sel = 0; // �޴�����
		String[] ch = { "�Ұ���", "����" };
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < reserve.length; i++) {
			reserve[i] = 0; // ȣ�� �ʱ�ȭ
		}
		while (!power) {
			System.out.println("=====ȣ�� �޴�=====");
			System.out.println("1.ȣ�ǿ��� 2.������� 3.ȣ��Ȯ�� 99.����");
			System.out.println("���Ͻô� �޴���ȣ�� �Է����ּ��� : ");
			sel = scan.nextInt();
			switch (sel) {
			case 1:
				System.out.print("===���� ȣ�ǿ��� ��Ȳ�Դϴ�.===");
				for (int i = 0; i < reserve.length; i++) {
					if (i % 5 == 0) {
						System.out.println();
					}
					if (reserve[i] == 0) {
						System.out.print(i + 1 + "ȣ�� : " + ch[1] + " ");
					} else {
						System.out.print(i + 1 + "ȣ�� : " + ch[0] + "");
					}
				}
					System.out.println("\n���Ͻô� ȣ�� ��ȣ�� �Է����ּ��� : ");
					sel = scan.nextInt();
					if(sel > reserve.length) {
						System.out.println("�߸��� ����");
						break;
					}
					if (reserve[sel - 1] == 0) {
						reserve[sel - 1] = 1;
						System.out.println(sel + "ȣ���� �����Ͽ����ϴ�.");
					}else {
						System.out.println("�̹� ������ �� ȣ���Դϴ�.\n�ٸ� ȣ���� �������ּ���.");
					}
				break;
			case 2:	//ȣ�� �������
				System.out.println("===�������===");
				System.out.println("��������� ȣ���� �Է����ּ��� : ");
				sel = scan.nextInt();
				if(sel > reserve.length) {
					System.out.println("�߸��� ����");
					break;
				}
				if(reserve[sel-1] == 0) {
					System.out.println("�� ȣ���� �̹� ����ֽ��ϴ�.");
				}else {
					reserve[sel-1] = 0;
				}
				System.out.println("������ ��ҵǾ����ϴ�.");
				break;
			case 3:
				System.out.print("===ȣ��Ȯ��===");
				for (int i = 0; i < reserve.length; i++) {
					if (i % 5 == 0) {
						System.out.println();
					}
					if (reserve[i] == 0) {
						System.out.print(i + 1 + "ȣ�� : " + ch[1] + " ");
					} else {
						System.out.print(i + 1 + "ȣ�� : " + ch[0] + " ");
					}
				}
				System.out.println();
				break;
			case 99: // ���α׷� ����
				System.out.println("����������������");
				power = true;
				break;
			}// switch �� ��
		} // while �� ��

	}

}
