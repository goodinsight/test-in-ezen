package func;

public class FuncTest01 {
	public static void main(String[] args) {
//		�μ��� ���� ���ѱ�
		int n1 = 0, n2 = 0;
		int s = 0;

//		�Է�
		n1 = 20;
		n2 = 30;

		s = sum(n1, n2);

		System.out.println("��: " + s);

	}

	static int sum(int n1, int n2) {
		return n1 + n2;
	}
}
