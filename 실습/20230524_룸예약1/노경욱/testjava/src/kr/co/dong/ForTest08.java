package kr.co.dong;

public class ForTest08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1���� 100 ���� 3�� ��� ���, 3�ǹ���� ��, 3�ǹ���� �������
		int hap = 0;
		int baesu = 0;

		System.out.print("1���� 100���� 3�� ���: ");

		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
				hap = hap + i;
				baesu++;
			}
		}
		System.out.println("\n1���� 100���� 3�� ������� ��: " + hap);
		System.out.println("1���� 100���� 3�� ����� ����: " + baesu);

	}

}
