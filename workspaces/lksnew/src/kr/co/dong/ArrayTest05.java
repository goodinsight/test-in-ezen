package kr.co.dong;

public class ArrayTest05 {
	public static void main(String[] args) {
//		p197 ArrayEx7.java �ڵ带 �ؼ��ؼ� �ۼ��غ���
		
		int[] iArr = new int[10];
		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = i;
			System.out.print(iArr[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < 100; i++) {
			int n1 = (int)(Math.random()*10);
			int n2 = (int)(Math.random()*10);
			
			int tmp = iArr[n1];
			iArr[n1] = iArr[n2];
			iArr[n2] = tmp;
			
		}
		for (int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i]+" ");
		}
	}
}
