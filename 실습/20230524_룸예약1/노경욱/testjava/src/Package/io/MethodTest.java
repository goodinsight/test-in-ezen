package Package.io;

import java.util.Scanner;

//���ڿ� �Է¹޾Ƽ� ���
//�μ��� ��, ��, ��, ����

public class MethodTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

//		����
		cal cal = null;
		boolean done = true;

//		�ʱ�ȭ��
		while (done) {
			System.out.println("���� ������  ����� ��������");
			System.out.println("1. �� 2. �� . 3 �� 4. ������");
			System.out.print("����� ����: ");
			int sel = scan.nextInt();
			int n1 = 0, n2 = 0, r = 0;
			switch (sel) {
			case 1:
				System.out.println("first Number: ");
				n1 = scan.nextInt();
				System.out.println("second Number: ");
				n2 = scan.nextInt();
				cal = new cal();
				r = cal.sum(n1, n2);
				System.out.println("�����: " + r);
				break;
			case 2:
				System.out.println("first Number: ");
				n1 = scan.nextInt();
				System.out.println("second Number: ");
				n2 = scan.nextInt();
				cal = new cal();
				r = cal.minus(n1, n2);
				System.out.println("�����: " + r);
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				break;
			}
		}
	}
}
