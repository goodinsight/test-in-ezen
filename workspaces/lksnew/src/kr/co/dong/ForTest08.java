package kr.co.dong;

public class ForTest08 {
	public static void main(String[] args) {
//		1���� 100���� 3�� ����� ����Ѵ�
//		3�� ����� ���� ���Ѵ�
//		�� ������� ���Ͽ� ����Ѵ�
		
		int num = 100;
		int sum = 0;
		int count = 0;
		
		System.out.print("1���� 100���� 3�� ��� : ");
		for (int i = 1; i<=100; i++) {
			if(i % 3 == 0) {
				System.out.print(i + " ");
				sum += i;
				count++;
			}
		}
		System.out.println();
		System.out.println("3�� ����� �� : " + sum);
		System.out.println("3�� ����� ���� : " + count);
	}
}
