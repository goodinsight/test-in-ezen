package kr.co.dong;

import java.util.Scanner;

public class Testjava {

	public static void main(String[] args) {
		// 세 정수를 콘솔로 입력 모니터로 출력
		//선언부분: 자료형타입 + 변수명
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
//		콘솔 호출하여 사용하기 : Scanner 클래스
		Scanner scan = null; //참조형
		
//		사용하기
		scan = new Scanner(System.in);
		
//		num1에 콘솔값 입력하기
		System.out.print("num1 정수입력: ");
		num1 = scan.nextInt();
		
//		num1 출력
		System.out.println(num1);
		
//		num2에 콘솔값 입력하기
		System.out.print("num2 정수입력: ");
		num2 = scan.nextInt();
		
//		num2 출력
		System.out.println(num2);
		
//		num1에 콘솔값 입력하기
		System.out.print("num3 정수입력: ");
		num3 = scan.nextInt();
		
//		num1 출력
		System.out.println(num3);
	}

}
