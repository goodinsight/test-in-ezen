package kr.co.dong;

import java.util.Scanner;

public class WhileTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		정수를 입력받아서 출력하고
//		999 정수는 시스템 종료!
		boolean done = false;
		int num = 0;
		Scanner scan = new Scanner(System.in);

		while (!done) {
			System.out.print("Input Data: ");
			num = scan.nextInt();
			if (num == 999) {
				break;
			}
//			} else {
//				System.out.println("입력받은 숫자: " + num);
//			}
			System.out.println("입력받은 숫자: " + num);
		}

		System.out.println("End");
	}

}
