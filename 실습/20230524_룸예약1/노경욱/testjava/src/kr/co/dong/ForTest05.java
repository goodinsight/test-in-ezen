package kr.co.dong;

import java.util.Scanner;

public class ForTest05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		���۰��� ���������� �Է¹޴´�
//		�� ���� ��� Ȧ���� ����Ѵ�.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("���۰��� �Է��ϼ���: ");
		int firstt = scan.nextInt();
		
		System.out.print("���������� �Է��ϼ���: ");
		int lastt = scan.nextInt();

		for (int i = firstt; i <= lastt; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
	}
}
