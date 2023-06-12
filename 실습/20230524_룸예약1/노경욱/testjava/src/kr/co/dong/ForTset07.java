package kr.co.dong;

import java.util.Scanner;

public class ForTset07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1부터 입력받은 수 까지의 합 구하기
		int hap = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
			hap = hap + i;
		}
		System.out.println(hap);
	}
	

}
