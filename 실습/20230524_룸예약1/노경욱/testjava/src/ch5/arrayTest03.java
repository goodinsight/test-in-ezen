package ch5;

public class arrayTest03 {
	public static void main(String[] args) {
//		10���� ������(1~100) ������ ���� �Է� �޾Ƽ�
//		�Էµ� �迭�� ���� ����ϰ� �� �迭�� ���� ���غ���.
//		int [] num = null;
//		int [] num = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] num = new int[10]; // ���� �� ����
		int hap = 0;

//		�迭 �ʱ�ȭ init : 7Line
		for (int i = 0; i < num.length; i++) {
			num[i] = 0;
		}

//		�迭�� ������ �Է�
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 100) + 1;
		}
//		�Է°� ���
		for (int i = 0; i < num.length; i++) {
			System.out.print("num[" + i + "]=" + num[i] + " ");
		}

//		�迭�� ���(element)�� ���� �� ���ϱ�
		for (int i = 0; i < num.length; i++) {
			hap += num[i];
		}

//		�� ���
		System.out.println("\nnum�迭�� ����: " + hap);

//		for��2 -> ���� for�� : ���� ���� ���
		for (int n : num) {
			System.out.println(n);
		}
//		��ձ��ϱ�
		float avg = (float)hap / num.length;
		System.out.println("���: " + avg);
	}
}
