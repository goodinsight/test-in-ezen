package kr.co.dong;

public class ForTest02 {
	public static void main(String[] args) {

		//		1+2+3+4+5 ~ +9 +10 �� ���� ���ϼ���
		int i  = 0;
		int n = 10;
		int sum = 0;
		for (i = 1; i <= n; i++) {
			sum += i;
			System.out.println("i=" + i + " �϶� sum = " + sum);
		}
		System.out.println("��������:" + sum);
	}
}
