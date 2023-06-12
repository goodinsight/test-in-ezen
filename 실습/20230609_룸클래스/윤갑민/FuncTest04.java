/*
 * 특수문자와 횟수를 입력받아서 그 횟수만큼 특수문자 반복 출력
 * printView(10, "$");
 * 
 * ==>"$$$$$$$$$$"
 * 
 * printView(3,"&")
 *  ===> "&&&"
 */


package kr.co.dong.func;

import java.util.Scanner;

public class FuncTest04 {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		// 메뉴 보여주기
		// 1. 두수의 합 구하기. 2. 구구단 3. 두 수 사이의 정수 구하기

		boolean done = false;
		int sel = 0;

		while (!done) {
			System.out.println("1. 두수의 합 구하기 2. 구구단 3. 두 수 사이 정수의 합 구하기 ");
			sel = scan.nextInt();

			switch (sel) {
			case 1:
				System.out.println("First Num : ");
				int a = scan.nextInt();
				System.out.println("Last Num : ");
				int b = scan.nextInt();
				int result = a + b;
				System.out.println(result);
				break;
			case 2:
				print99danAll();
				break;
			case 3:
				break;
			case 99:
				done = true;
			default:
				break;
			}
		}
		System.out.println("end!!");
	}

	// 1번 함수
	static void add(int a, int b) {
		int result = a + b;
		System.out.println("두수의 합 : " + result);
	}

	// 2번 함수
	static void print99danAll() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + "*" + i + " = " + (j * i) + " ");
			}
			System.out.println();
		}
	}
	// 3번 함수

}
