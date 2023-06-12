package kr.co.dong;

import java.util.Scanner;

public class WhileTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		정수 12345를 입력받아서 각 자리수의 합을 구하세요.
		int num = 0, sum = 0;
		Scanner scan = new Scanner(System.in);

//		입력
		System.out.print("정수를 입력하세요: ");
		num = scan.nextInt();
		
//		처리
		while (num != 0) {
			sum = sum + num % 10; //12345에 10을 나눈 나머지: 5
			num = num / 10;      //12345에 10을 나눈 몫:1234
		}
		
//		출력
		System.out.println(sum);
	}

}
