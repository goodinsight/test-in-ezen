package ch5;

public class ArrayTest08 {
	public static void main(String[] args) {
//		�ζ� ������(1~10)
		int[] lotto = null; // ����
		lotto = new int[6]; // ����

//		��ȣ�ޱ�
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 10) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;                          //for���� i���� �ٿ��� �ٽýõ�
				}
			}
		}
//		�ߺ�ó��

//		��ȣ�� ���
		for (int n : lotto) {
			System.out.print(n + ", ");
		}
	}
}
