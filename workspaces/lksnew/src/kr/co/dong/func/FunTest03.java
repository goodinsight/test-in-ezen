/*
 * ��� : ���� �迭�� �ʱ�ȭ, �迭�� �Է�, �迭�� ����, �迭�� ���
 * initArr(�迭��), inputArr(�迭��), sortArr(�迭��), printArr(�迭��)
 * 
 */
package kr.co.dong.func;

public class FunTest03 {
	static int[] numArr;
	
	public static void main(String[] args) {
//		10���� �迭�� ���� �Է� -> ���� -> ����ϱ�
		
		initArr(numArr);
		printArr(numArr);
		
	}
	static void printArr(int[] numArr) {
		for(int i = 0; i < numArr.length; i++) {
			System.out.println(numArr[i]);
		}
	}
	static void initArr(int[] n) {
		n = new int[10];
	}
}
