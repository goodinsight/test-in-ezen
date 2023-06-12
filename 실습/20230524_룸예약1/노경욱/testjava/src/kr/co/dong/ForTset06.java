package kr.co.dong;

import java.util.Scanner;

public class ForTset06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1부터 10까지의 합을 구하는데 1+2+3+~+10=45 이런식으로
		int hap = 0;
		int max = 10;
		for (int i = 1; i <= max; i++) {
			System.out.print(i);
			if (i != max) {
				System.out.print("+");
			}
			hap = hap + i;
		}
		System.out.print("=" + hap);
	}

}
