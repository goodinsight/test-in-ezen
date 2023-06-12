package kr.co.dong.func;

import java.util.Scanner;

public class FunTest04 {

	static Scanner scan = new Scanner(System.in);
	static boolean power = false;
	static boolean done = false;
	static String[] menu = { "����ִ� ���� ����~~~", "�μ��� �� ���ϱ�", "������ ���ϱ�", "�� �� ������ �� ���ϱ�", "            ���Ḧ ���ϸ�" };
	static String[] googooDanMenu = { "�������� ���غ��ƿ�~~~", "��� ������ ����", "���ϴ� �ܸ� ����", "���ϴ� ������ ���� ����", "���� �޴��� �̵��� ���ϸ�" };

	public static void main(String[] args) {
//		�޴� 1> �μ����ձ��ϱ� 2> ������ ���ϱ� 3> �� �� ������ �ձ��ϱ�
//		�� �޼���� �����ϱ�
		while (!power) {
			showMenu(menu);
			int tmp = inputNumber();
			mainMenu(tmp);
		}
		System.out.println("���α׷��� �����մϴ�.");
	}

	private static void mainMenu(int tmp) {
		// �޴� ���ý� �ϳ��� �̵�
		switch (tmp) {
		case 1:
			System.out.println("�� ���� �Է��Ͻø� ���� ���Ͻ� �� �ֽ��ϴ�.");
			int a = getNumber();
			int b = getNumber();
			dusooSum(a, b);
			break;
		case 2:
			while (!done) {
				showMenu(googooDanMenu);
				int tmp1 = inputNumber();
				googoodanMenu(tmp1);
			}
			break;
		case 3:
			System.out.println("�� ���� �Է��Ͻø� �μ� ������ ��� ���� ���� ���� �� �ֽ��ϴ�.");
			int d = getNumber();
			int e = getNumber();
			rangeSum(d, e);
			break;
		case 99:
			power = true;
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			break;
		}
	}

	private static void googoodanMenu(int tmp) {
		// TODO Auto-generated method stub
		switch (tmp) {
		case 1:
			googooDan();
			break;
		case 2:
			System.out.println("���� ���� ������ ���� ���� �� �ֽ��ϴ�.");
			int a = getNumber();
			googooDan(a);
			break;
		case 3:
			System.out.println("�� ���� �Է��Ͻø� �δ� ���� ���� �������� ���� �� �ֽ��ϴ�.");
			int b = getNumber();
			int c = getNumber();
			googooDan(b, c);
			break;
		case 99:
			done = true;
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			break;
		}
	}

	private static int getNumber() {
		// �Է� ���� �ޱ�
		System.out.println("���Ͻô� ������ �Է��ϼ���:");
		int num = scan.nextInt();
		return num;
	}

	private static int inputNumber() {
		// �޴� ��ȣ ������
		int tmp = scan.nextInt();
		return tmp;
	}

	private static void showMenu(String[] menu) {
		// �޴� ���� ȭ��
		System.out.println("======================================");
		System.out.println();
		System.out.println(menu[0]);
		System.out.println();
		System.out.println("1. " + menu[1]);
		System.out.println("2. " + menu[2]);
		System.out.println("3. " + menu[3]);
		System.out.println();
		System.out.println("======================================");
		System.out.println();
		System.out.println("�޴��� ������~(1~3)");
		System.out.println("            " + menu[4] + " 99 �Է�");
	}

	private static void rangeSum(int a, int b) {
		// �μ� ������ �������� ���� ���ϰ� ���.
		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum += i;
		}
		System.out.println(a + "(" + a + "����)���� " + b + "(" + b + "����)���̿� �ִ� �������� ��� ���ϸ� " + sum + "�̴�.");
	}

	private static void googooDan() {
		// �������� ���
		System.out.println("�������� ����� ����");
		for (int i = 2; i <= 6; i += 4) {
			for (int k = 0; k < 4; k++) {
				System.out.printf("=====" + (i + k) + "��=====");
				if (k != 3)
					System.out.print("\t");
				else
					System.out.print("\n");
			}
			for (int j = 1; j <= 9; j++) {
				for (int k = 0; k < 4; k++) {
					System.out.printf("%2d X%2d =%3d", i + k, j, (i + k) * j);
					if (k != 3)
						System.out.print("\t");
					else
						System.out.print("\n");
				}
			}
			System.out.println();
		}
	}

	private static void googooDan(int n) {
		// ������ n���� ����϶�
		System.out.println("������ " + n + "���� ����� ����");
		System.out.printf("=====" + n + "��=====%n");
		for (int j = 1; j <= 9; j++) {
			System.out.printf("%2d X%2d =%3d%n", n, j, n * j);
		}
	}

	private static void googooDan(int a, int b) {
		// ������ a�ܺ��� b�ܱ��� ����϶�
		System.out.println("������ " + a + "�ܿ��� " + b + "���� ����� ����");
		for (int i = a; i <= b; i++)
			System.out.printf("=====" + i + "��=====\t");
		System.out.println();
		for (int j = 1; j <= 9; j++) {
			for (int i = a; i <= b; i++)
				System.out.printf("%2d X%2d =%3d\t", i, j, i * j);
			System.out.println();
		}
	}

	private static void dusooSum(int a, int b) {
		// �� ���� ������ �޾Ƽ� ���� ����Ʈ
		System.out.println("�� �� " + a + "�� " + b + "�� �� :" + (a + b));
	}
}
