/*
 * Ctrl + Spacebar : 강추
 */
package kr.co.dong;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		// 세 정수를 콘솔로 입력받아서 모니터에 출력
		// 선언부분 : 자료형타입 + 변수명
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		// 콘솔 호출하여 사용하기 : Scanner 클래스
		Scanner scan = null; // 참조형
		// 사용하기
		scan = new Scanner(System.in);
		
//		num1에 콘솔값 입력하기
		System.out.print("첫번째 정수입력 : ");
		num1 = scan.nextInt();
		System.out.print("두번째 정수입력 : ");
		num2 = scan.nextInt();
		System.out.print("세번째 정수입력 : ");
		num3 = scan.nextInt();
//		num1 출력
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}

}
