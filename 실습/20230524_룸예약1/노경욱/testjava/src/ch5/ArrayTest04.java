package ch5;

public class ArrayTest04 {
	public static void main(String[] args) {
//		�ִ밪�� �ּҰ� ���غ���
		int[] score = { 79, 88, 91, 33, 100, 55, 95 };
		int min = 100; //score[0]�����ѵ�
		int max = 0;

//		�ִ밪 ���ϰ� �ּҰ� ���ϰ� ���� �ؾ� �ߴ���
//		�ϳ��� ��� ����Ѵٸ� else if		
//		�迭�� for�� ��Ʈ��
		for (int i = 0; i < score.length; i++) {
			if (min > score[i]) {
				min = score[i];
			}else if (max < score[i]) {
				max = score[i];
			}
		}

//		���
		System.out.println("�ִ밪: " + max);
		System.out.println("�ּҰ�: " + min);
	}
}
