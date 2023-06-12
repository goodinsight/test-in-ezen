package kr.co.dong;

import java.util.Scanner;

public class ArrayTest8_1 {
	public static void main(String[] args) {
//		로또 생성기(1~45)
//		입력받은 수만큼 로또생성하기
		
		int[][] lotto = null;	//선언
		int count;
		final int NUM = 6;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("몇장을 구매하시겠습니까?: ");
		count = scan.nextInt();
		
		lotto = new int[count][NUM];	//생성

		for(int n = 0; n < count; n++) {
			for (int i = 0; i < lotto.length; i++) {
				lotto[i][n] = (int)(Math.random()*45 + 1);
				for (int j = 0; j < i; j++) {
					if(lotto[i][n] == lotto[j][n]) {
						i--;	//i를 리셋하여 다시 받음
					}
				}
			}
		}
		for(int n = 0; n < count; n++) {
			System.out.print(n+1 +"번째 로또 번호는 [");
			for (int i = 0; i < lotto.length; i++) {
				System.out.printf("%2d",lotto[i][n]);
				if (i != lotto.length-1) {
					System.out.print(", ");
				}
			}
			System.out.print("] 입니다.");
			System.out.println();
		}
		
		
		
		
	}
}
