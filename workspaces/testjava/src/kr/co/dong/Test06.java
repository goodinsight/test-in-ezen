package kr.co.dong;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
//		�� ���� A�� B�� �־����� ��, A�� B�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//		ù° �ٿ� A�� B�� �־�����.
//		A�� B�� ���� �� ĭ���� ���еǾ��� �ִ�.
//		ex) �Է� : 10 20
//			int a = scan.nextInt();
//			int b = scan.nextInt();
//		ù° �ٿ� ���� �� ���� �� �ϳ��� ����Ѵ�.
//		A�� B���� ū ��쿡�� '>'�� ����Ѵ�.
//		A�� B���� ���� ��쿡�� '<'�� ����Ѵ�.
//		A�� B�� ���� ��쿡�� '=='�� ����Ѵ�.
		
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		
		if(A > B) {
			System.out.println(">");
		}else if(A < B) {
			System.out.println("<");			
		}else {
			System.out.println("==");
		}		
	}
}
