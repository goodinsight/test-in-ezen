package kr.co.dong;

import java.util.Scanner;

public class ArrayTest8_1 {
	public static void main(String[] args) {
//		�ζ� ������(1~45)
//		�Է¹��� ����ŭ �ζǻ����ϱ�
		
		int[][] lotto = null;	//����
		int count;
		final int NUM = 6;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �����Ͻðڽ��ϱ�?: ");
		count = scan.nextInt();
		
		lotto = new int[count][NUM];	//����

		for(int n = 0; n < count; n++) {
			for (int i = 0; i < lotto.length; i++) {
				lotto[i][n] = (int)(Math.random()*45 + 1);
				for (int j = 0; j < i; j++) {
					if(lotto[i][n] == lotto[j][n]) {
						i--;	//i�� �����Ͽ� �ٽ� ����
					}
				}
			}
		}
		for(int n = 0; n < count; n++) {
			System.out.print(n+1 +"��° �ζ� ��ȣ�� [");
			for (int i = 0; i < lotto.length; i++) {
				System.out.printf("%2d",lotto[i][n]);
				if (i != lotto.length-1) {
					System.out.print(", ");
				}
			}
			System.out.print("] �Դϴ�.");
			System.out.println();
		}
		
		
		
		
	}
}
