package kr.co.dong.checkPoint;

import java.util.Scanner;

public class NumberBaseball {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] CA = { 0, 0, 0, 0 };
		int[] MA = new int[4];
		int MAA = 0;
		int ran = 0;
		int count = 0;
		int num = 1000;
		int strike = 0;
		int ball = 0;
		int out = 0;

		for (int i = 0; i < CA.length; i++) {
			ran = (int) (Math.random() * 9) + 1;
			CA[i] = ran;
			for (int j = 0; j < i; j++) {
				if (CA[i] == CA[j]) {
					i--;
				}
			}
		}

//		for (int i = 0; i < CA.length; i++) {
//			System.out.print(CA[i] + " ");
//		}
		while (strike != 4) {
			num = 1000;
			strike = 0;
			ball = 0;
			out = 0;
			count += 1;
			System.out.print("4자리 숫자를 입력해 주세요 : ");
			MAA = scan.nextInt();
			for (int i = 0; i < MA.length; i++) {
				MA[i] = MAA / num;
				MAA = MAA % num;
				num = num / 10;
			}

//			for (int i = 0; i < MA.length; i++) {
//				System.out.print(MA[i] + " ");
//			}

			for (int i = 0; i < CA.length; i++) {
				for (int j = 0; j < MA.length; j++) {
					if (CA[i] == MA[j]) {
						if (i == j) {
							strike += 1;
						} else {
							ball += 1;
						}
					}
				}
			}
			out = 4 - strike - ball;
			System.out.println("\n" + strike + "스트라이크 " + ball + "볼 " + out + "아웃");
		}
		System.out.println("축하합니다! " + count + "번 만에 맞추셨습니다.");
//		MA[0] = MAA/1000;
//		MAA = MAA%1000;
//		MA[1] = MAA/100;
//		MAA = MAA%100;
//		MA[2] = MAA/10;
//		MAA = MAA%10;
//		MA[4] = MAA;

	}

}
