package func;

public class ArrayTest04 {
	public static void main(String[] args) {
//		�ִ밪�� �ּҰ� ���غ���
		int[] score = { 79, 88, 91, 33, 100, 55, 95 };
		int min = 100; // �ּҰ�
		int max = 0; // �ִ밪

//		�ִ밪 ���ϱ�: �Ű����� = score�迭/ return : �ִ밪����
		max = maxArr(score);
//		�ּҰ� ���ϱ�:
		min = minArr(score);
//		���
		System.out.println("�ִ밪: " + max);
		System.out.println("�ּҰ�: " + min);
	}

	static int minArr(int[] score) {
		int n = 101;
		for (int i = 0; i< score.length;i++){
			if (n > score[i]) {
				n = score[i];
			}
		}
		return n;
	}

	static int maxArr(int[] score) {
		int m = 0;
		for (int i = 0; i < score.length; i++) {
			if (m < score[i]) {
				m = score[i];
			}
		}
		return m;
	}
}
