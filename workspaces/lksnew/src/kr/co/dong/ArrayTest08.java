package kr.co.dong;

public class ArrayTest08 {
	public static void main(String[] args) {
//		�ζ� ������(1~45)
		int[] lotto = null;	//����
		lotto = new int[6];	//����
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45 + 1);
			for (int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;	//i�� �����Ͽ� �ٽ� ����
				}
			}
		}
	
		System.out.print("�ζ� ��ȣ�� [");
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i]);
			if (i != lotto.length-1) {
				System.out.print(", ");
			}
		}
		System.out.print("] �Դϴ�.");
		
		
		
		
	}
}
