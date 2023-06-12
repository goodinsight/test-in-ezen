package kr.co.dong;

import java.util.Scanner;

public class ForTest10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		구구단의 단수를 입력받아서 곱을 출력하세요
		Scanner scan = new Scanner(System.in);
		int dan = 0; // 단수
		int result = 0; // 결과값

		System.out.print("단수입력: ");
		dan = scan.nextInt();

		for (int i = 1; i <= 9; i++) {
			result = i * dan;
			System.out.println(dan + " x " + i + " = " + result);
		}
		System.out.println("=============================");
		
		for (dan = 2; dan<=9;dan++) {
			System.out.println("["+dan + "단"+"]");
			for(int i = 1 ; i <= 9; i++) {
				result = dan * i;
				System.out.println(dan + " x " + i + " = " + result);
			}
		}
	}	

}
