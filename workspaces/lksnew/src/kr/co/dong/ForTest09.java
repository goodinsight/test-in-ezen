package kr.co.dong;

import java.util.Scanner;

public class ForTest09 {
	public static void main(String[] args) {
//		���۰��� ������ ���� �Է¹޴´�.
//		�� ���� ���Ѵ�. (�� ���� ���� ���� ���Ѵ�.)
//		�߰� : ¦���� �� ���غ���
		int start = 0, end = 0, sum = 0, evenSum = 0;

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("���۰� : ");
			start = scan.nextInt();
			System.out.print("�������� : ");
			end = scan.nextInt();

			if (start < end) {
				break;
			}
			System.out.println("���۰��� ������������ �۵��� �ٽ� �Է��ϼ���");
		}

		for (int i = start; i <= end; i++) {
			sum += i;
			if (i % 2 != 1) {
				evenSum += i;
			}
		}

		System.out.printf("%d���� %d������ ��: %d%n", start, end, sum);
		System.out.printf("%d���� %d������ ¦���� ��: %d", start, end, evenSum);
	}
}
