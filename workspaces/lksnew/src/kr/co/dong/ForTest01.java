/*
 * �ۼ��� : �̱ټ�
 * �Ͻ� : 2023�� 5�� 8��
 * �� : Value
 * ���� : Reference
 * 
 */
package kr.co.dong;

import java.awt.print.Printable;
import java.util.Scanner;

public class ForTest01 {
	public static void main(String[] args) {
/*
//		1���� 10������ ���
		for (int i = 1; i <= 10; i++) {
			System.out.println("i=" + i);
		}
//		1���� n������ K�� ����� ����ϱ�
		int k = 0;
		int n = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("ã�� ���� ���� ������ ��������:");
		n = scan.nextInt();
		System.out.println("ã����� ����� ��������: ");

		k = scan.nextInt();
		for (int i = 1; i <= n; i++) {
			if (i % k == 0) {
				System.out.println("i=" + i);
			}
		}
*/		
		
		
//		��� ǥ�� 3, 6, 9, 12
//		        15, 18, 21, 24
		int k = 0, l = 0, j = 0, n = 0;
		String comma = ",";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("1���� ����� ���ұ��?: ");
		n = scan.nextInt();
		System.out.println("���: ");
		k = scan.nextInt();
		System.out.println("���ٿ� ǥ���� ����: ");
		l = scan.nextInt();
		System.out.println("�������� �����ұ��?: ");
		comma = scan.next();
		
		for (int i = 1; i <= n; i++) {
			if (i % k == 0) {					// i�߿��� k����� ���� 
				System.out.print(i);			// i���� ���
				j += 1;							// counting
				if ( j != n / k  ) {			// ������ ������ ���ڿ� �ٸ� ��츸 ���� -> ���������� �޸��� ������
					if (j % l != 0) {			
						System.out.print(comma);// ������ ���ٿ� ǥ�� ����(l) �� �ٸ� ��� �޸�
					} else {
						System.out.println();   // ������ l�� �Ǹ� �ٹٲ�
 					}
				}
			}
		}
		
		
		
	}
}
