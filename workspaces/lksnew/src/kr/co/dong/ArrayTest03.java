package kr.co.dong;

public class ArrayTest03 {
	public static void main(String[] args) {
//		10���� ������(1~100) ������ ���� �Է¹޾Ƽ�
//		�Էµ� �迭�� ���� ����ϰ� �� �迭�� ���� ���غ���.
		
		int[] num = null;
		int sum = 0;
		int size = 10;
		
		num = new int[size];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random()*100 + 1);
			sum += num[i];
		}
		System.out.println("�Էµ� ������ �迭��");
		for (int i : num) {
			System.out.print(num[i]);
			if (i != num.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.println("������ �迭�� ���� " + sum + "�Դϴ�.");
		
		
	}
}
