package kr.co.dong;

public class RandomTest01 {

	public static void main(String[] args) {
//		����: 0.0 ~ 0.999999999 ������ ��
		System.out.println(Math.random());
		
//		for(�ʱⰪ; ����; ����ġ){
//			���๮ <- ������ ���̸� ����
//		}
		System.out.println("----------------------------");
		for(int i=1; i <=6; i++) {	
			System.out.println(i + "�϶�, " + Math.random());
		}
//		Math.random() -> 0 ~ 0.99999999 ������ ��
//		Math.random() * 10 -> 0 ~ 9.99999999
//		0 ~ 9 ������ ���� ���ϱ�
		System.out.println((int)(Math.random() * 10));
		System.out.println((int)(Math.random() * 10));
		System.out.println((int)(Math.random() * 10));
		System.out.println((int)(Math.random() * 10));
		System.out.println((int)(Math.random() * 10));		
//		0 ~ 7 ������ ������ ����
		System.out.println((int)(Math.random() * 8));
		
//		1 ~ 10������ ������ ����
		System.out.println((int)(Math.random() * 10) + 1);
		
//		1 ~ 45������ ������ ����
		System.out.println((int)(Math.random() * 45) + 1);
		
		
//		13 ~ 16������ ������ ����
		System.out.println((int)(Math.random() * 4) + 13);
		
//		3 ~ 15 ������ ������ ����
		System.out.println((int)(Math.random() * 13) + 3);
		
	}

}
