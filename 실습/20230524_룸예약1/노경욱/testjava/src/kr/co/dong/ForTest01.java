/*
 * �ۼ���: ����
 * ��: Value
 * ����: Reference
 */

package kr.co.dong;

public class ForTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1���� 10������ ���
		for (int i = 1; i <= 10; i++) {
			System.out.println("i=" + i);
		}

//		1���� 100������ 3�� ����� ����ϱ�
		int stack = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				System.out.print(i);
				stack++;
				if (stack == 4) {
//				if(i % 12 == 0){ 12����϶� �ٹٲ��� ���
					System.out.print("\n");
					stack = 0;
				} else {
					System.out.print(",");
				}

			}
		}
	}

}
