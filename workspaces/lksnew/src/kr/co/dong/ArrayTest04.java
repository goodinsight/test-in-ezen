package kr.co.dong;

public class ArrayTest04 {
	public static void main(String[] args) {
//		�ִ밪�� �ּҰ��� ���غ���

		int[] score = { 79, 88, 91, 33, 100, 55, 95 };
		int max = 0;
		int min = 0;

//		for (int i = 0; i < score.length; i++) {
//			if (score[i] > max) {
//				max = score[i];
//			}
//		}
//		min = max;
//		for (int i =0; i < score.length; i++) {
//			if (score[i] < min) {
//				min = score[i];
//			}
//		}
		max = score[0];
		min = score[0];
		for (int i = 1; i < score.length; i++) {
			if (score[i] > max) {
				max = score[i];
			}
			if (score[i] < min) {
				min = score[i];
			}
		}

		System.out.println("�ִ밪 : " + max);
		System.out.println("�ּҰ� : " + min);
	}
}
