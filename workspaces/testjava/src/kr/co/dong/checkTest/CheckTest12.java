package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest12 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// ���� �Ը� �ޱ� �� ����
		System.out.println("���� �Ը� �Է��ϼ���");
		int how = scan.nextInt();
		int tmp = 0, tmp2 = 0;
		String tmp3 = "";

		String tmp1 = "";
		int[][] room = new int[how][5]; // 0 �̸� 1 �����ο� 2 ���� 3 �����Ȳ(�����-1 �̿������-0) 4 ���� ��ȣ
		String[][] roomTag = new String[how][2]; // 0 ȣ��Ư�� 1 �����ڸ�
		boolean power = true;
		boolean power2 = true;

		for (int i = 0; i < room.length; i++) {
			// �� Ư�� ����, ���� ����
			how = (int) (Math.random() * 2 + 1);
			if (how == 1) {
				roomTag[i][0] = "�����̾�";
				room[i][2] = 150000;
			} else {
				roomTag[i][0] = "�Ϲ�";
				room[i][2] = 75000;
			}
			// ������ �� �̸��� 101 102 �̷�������
			room[i][0] = 100 + (i + 1);
			// �����ο� ����
			how = (int) (Math.random() * 3 + 1);
			room[i][1] = how;
			// ��� �̿�������
			room[i][3] = 0;
		}
		for (int i = 0; i < room.length; i++) {
			System.out.printf("�̸�: %dȣ �����ο�: %d ����: %6d Ư��: %s�̸� ", room[i][0], room[i][1], room[i][2], roomTag[i][0]);
			if (room[i][3] == 1) {
				System.out.println("����Ǿ����ϴ�.");
			} else {
				System.out.println("����Ǿ������ʽ��ϴ�");
			}
		}

		System.out.println();

		while (power) {
			power2 = true;
			System.out.println("1: �����ϱ� /// 2: ������� /// 3: �����Ȳ /// 4: ����");
			tmp = scan.nextInt();
			switch (tmp) {
			default:
				System.out.println("�ٽ� �Է��� �ּ���");
				break;
			case 4:
				power = false;
				System.out.println("�����մϴ�...");
				break;
			case 3:
				for (int i = 0; i < room.length; i++) {
					System.out.printf("�̸�: %dȣ �����ο�: %d ����: %6d Ư��: %s�̸� ", room[i][0], room[i][1], room[i][2],
							roomTag[i][0]);
					if (room[i][3] == 1) {
						System.out.println("����Ǿ����ϴ�.");
					} else {
						System.out.println("����Ǿ������ʽ��ϴ�");
					}
				}
				break;
			case 1:
				System.out.println("������ ���� ��ȣ�� �Է��� �ּ���(101ȣ ����) (0�Է½� ����)");
				while (true) {
					tmp = scan.nextInt();
					if (tmp == 0) {
						break;
					}else if (tmp > 100) { //tmp�� 105ȣ �̷���
						if (tmp - 101 > room.length) { //������ ��ũ�⺸�� Ŭ�� �ٽ� �Է�
							System.out.println("�ٽ� �Է��� �ּ���");
						} else {    //������ Ż��
							break;
						}
					} else { //tmp�� 5ȣ �̷���
						if (tmp > room.length) {
							System.out.println("�ٽ� �Է��� �ּ���");
						}else {
							break;
						}
					}
				}
				if (tmp == 0) {
					break;
				}
				if (tmp < 100) {
					tmp += 100;
				}
				while (power2) {
					if (tmp == 0) {
						power2 = false;
					} else if (room[tmp - 101][3] == 1) {
						System.out.println("�� ���� �̹� ���� �Ǿ� �ֽ��ϴ�");
					} else {
						System.out.println("�����ڸ��� �Է��� �ּ���");
						tmp1 = scan.next();
						roomTag[tmp - 101][1] = tmp1;
						System.out.println("�����ȣ 4�ڸ�(����)�� �Է��� �ּ���");
						tmp2 = scan.nextInt();
						room[tmp - 101][4] = tmp2;
						System.out.println(roomTag[tmp - 101][1] + "�� ����Ǿ����ϴ�");
						room[tmp - 101][3] = 1;
						power2 = false;
					}
				}
				break;
			case 2:
				System.out.println("��������� ���� ��ȣ�� �Է��� �ּ���(101ȣ ����) (0�Է½� ����)");
				while (true) {
					tmp = scan.nextInt();
					if (tmp == 0) {
						break;
					}else if (tmp > 100) { //tmp�� 105ȣ �̷���
						if (tmp - 101 > room.length) { //������ ��ũ�⺸�� Ŭ�� �ٽ� �Է�
							System.out.println("�ٽ� �Է��� �ּ���");
						} else {    //������ Ż��
							break;
						}
					} else { //tmp�� 5ȣ �̷���
						if (tmp > room.length) {
							System.out.println("�ٽ� �Է��� �ּ���");
						}else {
							break;
						}
					}
				}
				if (tmp == 0) {
					break;
				}
				if (tmp < 100) {
					tmp += 100;
				}
				if (room[tmp - 101][3] == 0) {
					System.out.println(room[tmp - 101][0] + "�� ����Ǿ� ���� ���� �����Դϴ�");
				} else {
					while (power2) {
						System.out.println("�����ȣ(����)�� �Է��� �ּ��� (0�Է½� ����)");
						tmp2 = scan.nextInt();
						if (tmp2 == 0) {
							power2 = false;
							break;
						} else if (room[tmp - 101][4] == tmp2) {
							System.out.println("������ ����Ͽ����ϴ�");
							room[tmp - 101][3] = 0;
							power2 = false;
						} else {
							System.out.println("�����ȣ�� �ٸ��ϴ�");
						}
					}
				}
				break;
//	������ ��� ȣ��Ư��, ����, \�ο� �������
// room 0 �̸� 1 �����ο� 2 ���� 3 �����Ȳ(�����-1 �̿������-0) 4 ���� ��ȣ
// roomTag 0 ȣ��Ư�� 1 �����ڸ�
			case 77:
				System.out.println("������ ��带 �����մϴ�");
				while (power2) {
					System.out.println("1: ȣ��Ư������ /// 2: �ο����� /// 3: ���ݺ��� /// 0: ����");
					tmp2 = scan.nextInt();
					switch (tmp2) {
					case 0:
						power2 = false;
						System.out.println("������ ��带 �����մϴ�");
						break;
					case 1:
						System.out.println("��� ȣ���� Ư���� �����Ͻó���?");
						while (true) {
							tmp = scan.nextInt();
							if (tmp == 0) {
								break;
							}else if (tmp > 100) { //tmp�� 105ȣ �̷���
								if (tmp - 101 > room.length) { //������ ��ũ�⺸�� Ŭ�� �ٽ� �Է�
									System.out.println("�ٽ� �Է��� �ּ���");
								} else {    //������ Ż��
									break;
								}
							} else { //tmp�� 5ȣ �̷���
								if (tmp > room.length) {
									System.out.println("�ٽ� �Է��� �ּ���");
								}else {
									break;
								}
							}
						}
						if (tmp == 0) {
							break;
						}
						if (tmp < 100) {
							tmp += 100;
						}
						System.out.println("���� " + tmp + "ȣ�� Ư���� " + roomTag[tmp - 101][0] + "�Դϴ�");
						System.out.println("�������κ����ϳ���? �����̾�/�Ϲ�");
						tmp3 = scan.next();
						System.out.println(tmp + "ȣ�� Ư���� " + tmp3 + "�� �����մϴ�");
						roomTag[tmp - 101][0] = tmp3;
						break;
					case 2:
						System.out.println("��� ȣ���� �ִ��ο��� �����Ͻó���?");
						tmp = scan.nextInt();
						while (true) {
							tmp = scan.nextInt();
							if (tmp > 100) { //tmp�� 105ȣ �̷���
								if (tmp - 101 > room.length) { //������ ��ũ�⺸�� Ŭ�� �ٽ� �Է�
									System.out.println("�ٽ� �Է��� �ּ���");
								} else {    //������ Ż��
									break;
								}
							} else { //tmp�� 5ȣ �̷���
								if (tmp > room.length) {
									System.out.println("�ٽ� �Է��� �ּ���");
								}else {
									break;
								}
							}
						}
						if (tmp < 100) {
							tmp += 100;
						}
						System.out.println("���� " + tmp + "ȣ�� �ִ��ο��� " + room[tmp - 101][1] + "�Դϴ�");
						System.out.println("�������κ����ϳ���?");
						tmp2 = scan.nextInt();
						System.out.println(tmp + "ȣ�� �ִ��ο��� " + tmp2 + "�� �����մϴ�");
						room[tmp - 101][1] = tmp2;
						break;
					case 3:
						System.out.println("��� ȣ���� ������ �����Ͻó���?");
						while (true) {
							tmp = scan.nextInt();
							if (tmp > 100) { //tmp�� 105ȣ �̷���
								if (tmp - 101 > room.length) { //������ ��ũ�⺸�� Ŭ�� �ٽ� �Է�
									System.out.println("�ٽ� �Է��� �ּ���");
								} else {    //������ Ż��
									break;
								}
							} else { //tmp�� 5ȣ �̷���
								if (tmp > room.length) {
									System.out.println("�ٽ� �Է��� �ּ���");
								}else {
									break;
								}
							}
						}
						tmp = scan.nextInt();
						if (tmp < 100) {
							tmp += 100;
						}
						System.out.println("���� " + tmp + "ȣ�� ������ " + room[tmp - 101][2] + "�Դϴ�");
						System.out.println("�������κ����ϳ���?");
						tmp2 = scan.nextInt();
						System.out.println(tmp + "ȣ�� ������ " + tmp2 + "�� �����մϴ�");
						room[tmp - 101][2] = tmp2;
						break;
					}
				}
				break;
			}
		}
	}
}
