package kr.co.dong;

import java.util.Scanner;

public class FlowEx6_b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		����ڿ��� 1(����), 2(����), 3(��)�� �Է¹ް�
//		��ǻ�ʹ� ������ �� (1~3)������ ���� �޾Ƽ�
//		������� �¸����θ� ����ϴ� ���α׷��� �ۼ��ϼ���
		System.out.print("����:1 ����:2 ��:3 �߿� �ϳ��� �Է��Ͻÿ�(����): ");
		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt();

		int com = (int) (Math.random() * 3) + 1;
//					(int)<- int�� ��ȯ (Math.random() * �Ѱ���) + ������
		switch (user) {
		case 1:
			if (com == 1) {
//			switch (com) {
//			case 1: //user�� 1�϶� com�� 1 2 �̷���
				System.out.println("�����ϴ�");
			} else if (com == 2) {
				System.out.println("�й�");
			} else {
				System.out.println("�¸�");
			}
			break;
		case 2:
			if (com == 2) {
				System.out.println("�����ϴ�");
			} else if (com == 3) {
				System.out.println("�й�");
			} else {
				System.out.println("�¸�");
			}
			break;
		case 3:
			if (com == 3) {
				System.out.println("�����ϴ�");
			} else if (com == 1) {
				System.out.println("�й�");
			} else {
				System.out.println("�¸�");
			}
			break;
		}
	}

}
