package kr.co.dong;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
//		�� ���� A, B, C�� �־�����
//		�̶�, �ι�°�� ū ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		
		if (A >= B && A >= C) {
			if (B >= C) {
				System.out.println(B);
			} else {
				System.out.println(C);
			}
		} else if (B >= C) {
			if (A >= C) {
				System.out.println(A);
			} else {
				System.out.println(C);
			}
		} else {
			if (A >= B) {
				System.out.println(A);
			} else {
				System.out.println(B);
			}
		}
	}

}
