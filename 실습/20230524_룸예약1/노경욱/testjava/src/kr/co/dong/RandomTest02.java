package kr.co.dong;

public class RandomTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	�ֻ��� 2���� ��(������ ��)�� ���� 10 �����̸� ��÷, �ƴϸ� ��÷�� �ƴ�
		int dice1 = (int)(Math.random() * 6) + 1;
		int dice2 = (int)(Math.random() * 6) + 1;
		int hap = dice1 + dice2;
		String result = "abc";
		
		if (hap <= 10) {
			result = "��÷";
		}else {
			result = "��÷�� �ƴմϴ�.";
		}
		
		System.out.println("�ֻ���1:" + dice1 + " "+ "�ֻ���2:" + dice2 + " " + "\n�ΰ��� �ֻ����� ��:" + hap + "\n���:" + result);
	}

}
