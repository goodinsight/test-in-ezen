package ch5;

public class ArrayTest05 {
	public static void main(String[] args) {
//		p197 ArrayEx7.java �ڵ带 �ؼ��ؼ� �ۼ��غ���
		int[] numArr = new int[10];

		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = i;
			System.out.print(numArr[i]);
		}
		
		System.out.println();

		for (int i = 0; i < 100; i++) {
			int n = (int) (Math.random() * 10); //���� �� n ����
			int tmp = numArr[0];               //tmp�� numArr�� 0��° ��
			numArr[0] = numArr[n];			  //numArr[0]�� numArr[n]�� ������
			numArr[n] = tmp;				 //numArr[n]�� numArr�� 0��° ��  
		}								 	//0�� ���� tmp�� �����ϰ� / n��° ���� 0�� �ְ� / 0�ǰ��� tmp�� n��° ���� �ִ´�
										   //0�� n��° ���� �ٲ۴ٴ� ��
		
		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i]);
		}
	}
}
