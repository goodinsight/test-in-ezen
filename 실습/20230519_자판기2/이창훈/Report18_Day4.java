package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report18_Day4 {

	public static void main(String[] args) {
		boolean power = false; // ����

		int items = 3; // ��ǰ ����
		String[] dName = new String[items]; // �̸�
		int[] dPrice = new int[items]; // ����
		int[] dAmount = new int[items]; // ����
		int money = 0;
		int moneys[] = { 50, 100, 500, 1000 };
		int tmoney[] = new int[moneys.length];
		int nmoney[] = new int[moneys.length];

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < tmoney.length; i++) { // �ʱ� �������� : ���� 10��
			tmoney[i] = 10;
		}

		while (!power) {
			int adminS = 0; // �����ڸ޴�
			int itemN = 0; // ��ǰ��ȣ
			int select = 0;
			System.out.println("==================================");
			System.out.println("���� �ܾ�:" + money + " (���Է�: 50,100,500,1000)");
			System.out.println("�����ȣ�� �����ϼ��� �ܵ���ȯ:9��");
			for (int i = 0; i < dName.length; i++) {
				System.out.print(i + "��:" + dName[i] + "(" + dPrice[i] + "��) ");
			}
			select = scan.nextInt();

			// ���ᳪ���� ����
			for (int i = 0; i < dName.length; i++) {
				if (i == select) {
					if (dPrice[i] > money) {
						System.out.println("���� �����մϴ�!");
						continue;
					} else if (dAmount[i] == 0) {
						System.out.println("��� �����մϴ�!");
						continue;
					} else {
						System.out.println(dName[i] + "(��)�� ���Խ��ϴ�.");
						money -= dPrice[i];
						dAmount[i]--;
						break;
					}

				}
			}

			switch (select) {
			case 50:
				money += moneys[0];
				tmoney[0]++;
				continue;

			case 100:
				money += moneys[1];
				tmoney[1]++;
				continue;

			case 500:
				money += moneys[2];
				tmoney[2]++;
				continue;

			case 1000:
				money += moneys[3];
				tmoney[3]++;
				continue;

			case 9: // �Ž�����
				System.out.println("==================================");
				System.out.println("�Ž����� " + money + "�� �Դϴ�.");
				if (money < moneys[3]) { // �ܵ� õ���̸� = ������ õ�� ī��Ʈ ����
					nmoney[3] = 0;
				} else if (nmoney[3] <= 1 && money < 2000) { // ����� ���常 ��ȯ�ǰ� ����
					money -= moneys[3];
					nmoney[3] -= nmoney[3] - 1;
				} else if (nmoney[3] > 1 && money >= 2000) {
					nmoney[3] -= nmoney[3] - 1;
					money -= nmoney[3] * moneys[3];
				}

				nmoney[2] = money / moneys[2]; // 500�� ó��
				money -= nmoney[2] * moneys[2];
				nmoney[1] = money / moneys[1]; // 100�� ó��
				money -= nmoney[1] * moneys[1];
				nmoney[0] = money / moneys[0]; // 50�� ó��
				money -= nmoney[0] * moneys[0];

				for (int i = 0; i < nmoney.length; i++) {
					tmoney[i] -= nmoney[i]; // ��ü ������ ����
					System.out.print(moneys[i] + "��:" + nmoney[i] + " ");
				}
				System.out.println(); // �ٹٲ�
				continue;

			case 99: // �����ڹ�ȣ
				while (!(adminS == 9)) {
					System.out.println("==================================");
					System.out.println(">>������ ����Դϴ�<<");
					System.out.println(">>���ϴ� ������ ��ȣ�� �Է����ּ���.<<");
					System.out.println("1)�����̸����� 2)���ݼ��� 3)������");
					System.out.print("7)�������� 8)�����缳�� 9)�������� 0)���Ǳ�����");
					adminS = scan.nextInt();
					switch (adminS) {
					case 1:
						System.out.println("==================================");
						System.out.println("�̸��� �ٲ� �����ȣ�� �Է��ϼ���");
						System.out.println("���� ������� �̸�");
						for (int i = 0; i < dName.length; i++) {
							System.out.print(i + "��" + dName[i] + " ");
						}
						itemN = scan.nextInt();

						for (int i = 0; i < dName.length; i++) {
							if (i == itemN) {
								System.out.println("���ο� ������ �̸���?");
								dName[i] = scan.next();
							}
						}
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						continue;

					case 2:
						System.out.println("==================================");
						System.out.println("������ �ٲ� �����ȣ�� �Է��ϼ���");
						System.out.println("���� ������ �̸��� ����");
						for (int i = 0; i < dName.length; i++) {
							System.out.print(i + "��:" + dName[i] + "(" + dPrice[i] + "��) ");
						}
						itemN = scan.nextInt();

						for (int i = 0; i < dName.length; i++) {
							if (i == itemN) {
								System.out.println("�缳���� ������?");
								dPrice[i] = scan.nextInt();
							}
						}
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						continue;

					case 3:
						System.out.println("==================================");
						System.out.println("������ �ٲ� �����ȣ�� �Է��ϼ���");
						System.out.println("���� ������ �̸�");
						for (int i = 0; i < dName.length; i++) {
							System.out.print(i + "��" + dName[i] + " ");
						}
						itemN = scan.nextInt();

						for (int i = 0; i < dName.length; i++) {
							if (i == itemN) {
								System.out.println("�� ������ ���� ����?");
								dAmount[i] = scan.nextInt(); // ���߿� ��� ���ϱ�,����� �ٲٱ�
							}
						}
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						continue;
					case 7:
						System.out.println("==================================");
						System.out.println("���� �����ִ� ���� ���Դϴ�.");
						for (int i = 0; i < tmoney.length - 1; i++) {
							System.out.println(moneys[i] + "�� " + tmoney[i] + "��");
						}
						// ���� ���� ���� ���� ��������
						continue;

					case 8:
						System.out.println("==================================");
						System.out.println("�缳���� ������ ��ȣ�� �Է��ϼ���");
						System.out.println("���� ������ �̸�");
						for (int i = 0; i < dName.length; i++) {
							System.out.print(i + "��" + dName[i] + " ");
						}

						itemN = scan.nextInt();

						System.out.println("������ �����մϴ�.");
						for (int i = 0; i < dName.length; i++) {
							if (i == itemN) {
								System.out.println("���ο� ������ �̸���?");
								dName[i] = scan.next();
								System.out.println("���ο� ������ ������?");
								dPrice[i] = scan.nextInt();
								System.out.println("���ο� ������ ���� ������?");
								dAmount[i] = scan.nextInt();
							}
						}
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						continue;

					case 9:
						System.out.println("������ ��� ��ħ.");
						break;

					case 0:
						power = true;
						break;
					}

				}

			}
		}
		System.out.println("���Ǳ� ����!!");
		scan.close();
	}

}