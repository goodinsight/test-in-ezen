package kr.co.dong.func;

public class FunTest01 {
	public static void main(String[] args) {
//		�μ��� �� ���ϱ�
		int n1 = 0, n2 = 0;
		int s = 0;
//		�Է�
		n1 = 20;
		n2 = 30;
//		ó��: �μ��� ���� ���ϴ� �Լ�
		s = sum(n1, n2);

		System.out.println("�� : " + s);
		
		sum2(n1, n2);
		
	}

	static int sum(int n1, int n2) {
		return n1 + n2;
	}
	static void sum2(int n1, int n2) {
		System.out.println("�� : " + (n1+n2));
	}
}
