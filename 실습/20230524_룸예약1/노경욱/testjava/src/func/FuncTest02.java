package func;

public class FuncTest02 {
	public static void main(String[] args) {
//		�μ��� ���� ���ѱ�
		int n1 = 0, n2 = 0;
		int s = 0;

//		�Է�
		n1 = 20;
		n2 = 30;

		sum(n1, n2);
		
		sum(40,30);
	}

	static void sum(int n1, int n2) {
		System.out.println("��:" + (n1 + n2));
	}
}
