package kr.co.dong;

public class WhileTest02 {
	public static void main(String[] args) {
//		1���� 10���� �� ���ϱ� -> while������
		int sum1 = 0;

		for (int i = 1; i <= 10; i++) {
			sum1 += i;
		}
		System.out.println("�� : " + sum1);

		int i = 0;
		int sum2 = 0;
		while (i <= 10) {
			sum2 += i;
			i++;
		}
		System.out.println("�� : " + sum2);
	}
}
