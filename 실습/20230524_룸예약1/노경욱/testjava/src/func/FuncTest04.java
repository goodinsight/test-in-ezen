package func;

import java.util.Scanner;

public class FuncTest04 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		�޴� 1> �μ��� �� ���ϱ� 2> ������ ���ϱ� 3> �� �� ������ �� ���ϱ�
//		�� �޼���� �����ϱ�

		boolean done = false;
		int sel = 0;
		int a1 = 0, b1 = 0, gugugot = 0;

		while (!done) {
			sel = menuView();
			switch (sel) {
			case 99:
				System.out.println("�����մϴ�");
				done = true;
				break;
			case 1:
				duHap(a1, b1);
				break;
			case 2:
				gugu(gugugot); // ������ ���
				break;
			case 3:
				rangeHap(a1, b1); // �� �� ������ ���� ���
				break;
			default:
				System.out.println("�ٽ� �Է��� �ּ���");
				break;
			}
		}
	}

	static int menuView() {
		// TODO Auto-generated method stub
		System.out.println("1: �μ��� �� ���ϱ� /// 2: ������ ���ϱ� /// 3: �� �� ������ �� ���ϱ� /// 99: ����");
		return scan.nextInt();
	}

	static void duHap(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("\n�μ��� �� ���ϱ�");
		System.out.print("ù��° ���ڸ� �Է��� �ּ���: ");
		int a1 = scan.nextInt();
		System.out.print("�ι�° ���ڸ� �Է��� �ּ���: ");
		int b1 = scan.nextInt();
		System.out.println(a1+b1);
	}

	static void gugu(int a) {
		System.out.println("\n�����ܿ��� ���° ���� ���Ͻó���?: ");
		int gugugot = scan.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.println(gugugot + " x " + i + " = " + gugugot * i);
		}
	}

	static void rangeHap(int a, int b) {
		System.out.println("\n�� �� ������ ���� ���ϱ�");
		System.out.print("ù��° ���ڸ� �Է��� �ּ���: ");
		a = scan.nextInt();
		System.out.print("�ι�° ���ڸ� �Է��� �ּ���: ");
		b = scan.nextInt();
		int allHap = 0;
		if (a < b) {
			for (int i = a + 1; i < b; i++) {
				allHap += i;
			}
			System.out.println(allHap);
		} else {
			for (int i = b + 1; i < a; i++) {
				allHap += i;
			}
			System.out.println(allHap);
		}
	}
}
