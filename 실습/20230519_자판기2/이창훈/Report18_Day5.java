package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report18_Day5 {
	// �Ž����� �Ϸ�
	//����������: �������� �����ϱ�
	public static void main(String[] args) {
		boolean power = false; // ����

		int items = 3; // ��ǰ ����
		String[] dName = new String[items]; // �̸�
		int[] dPrice = new int[items]; // ����
		int[] dAmount = new int[items]; // ����
		int money = 0;
		int moneys[] = { 50, 100, 500, 1000 };
		int summoney[] = new int[moneys.length];
		int inmoney[] = new int[moneys.length];
		int tempcoin = 0;

		// �׽�Ʈ�� ����
		dName[0] = "�����";
		dPrice[0] = 1800;

		for (int i = 0; i < summoney.length; i++) { // �ʱ� �������� : ���� 10��
			summoney[i] = 10;
		}

		Scanner scan = new Scanner(System.in);
		while (!power) {
			int adminS = 0; // �����ڸ޴�
			int itemN = 0; // ��ǰ��ȣ
			int select = 0;
			System.out.println("==================================");
			System.out.println("���� �ܾ�:" + money + " (���Է�>>50,100,500,1000�� �Է�)");
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
						while (!(inmoney[3] * moneys[3] < money)) {
							inmoney[3]--;
							continue;
						}
					}
				}
			}

			switch (select) {
			case 50:
				money += moneys[0];
				summoney[0]++;
				inmoney[0]++;
				continue;

			case 100:
				money += moneys[1];
				summoney[1]++;
				inmoney[1]++;
				continue;

			case 500:
				money += moneys[2];
				summoney[2]++;
				inmoney[2]++;
				continue;

			case 1000:
				money += moneys[3];
				summoney[3]++;
				inmoney[3]++;
				continue;

			case 9: // �Ž�����
				System.out.println("==================================");
				System.out.println("�Ž����� " + money + "�� �Դϴ�.");
				if (money <= 1000) {
					inmoney[3] = 0;
				}
				if (money >= 1000 && inmoney[3] >= 1) {
					while (!(inmoney[3] == 1)) {
						money -= moneys[3];
						inmoney[3]--;
						tempcoin += 2;
					}
					tempcoin -= 2;
				}

				inmoney[2] = money / moneys[2]; // 500�� ó��
				money -= inmoney[2] * moneys[2];
				inmoney[2] += tempcoin; // ����>���� ��ȯ �ݿ�
				
				inmoney[1] = money / moneys[1]; // 100�� ó��
				money -= inmoney[1] * moneys[1];
				
				inmoney[0] = money / moneys[0]; // 50�� ó��
				money -= inmoney[0] * moneys[0];

				for (int i = 0; i < inmoney.length; i++) {
					summoney[i] -= inmoney[i]; // ���Ǳ� ������ ����
					System.out.print(moneys[i] + "��:" + inmoney[i] + " ");
					inmoney[i] = 0; // ��ȯ�� ����ī��Ʈ ����
				}
				tempcoin = 0;
				System.out.println();
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
						for (int i = 0; i < summoney.length - 1; i++) {
							System.out.println(moneys[i] + "�� " + summoney[i] + "��");
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
						power = true; // ���� ����
						adminS = 9; // ������ while�� �����
						break;
					}
				}
			}
		}
		System.out.println("���Ǳ� ����!!");
		scan.close();
	}
}