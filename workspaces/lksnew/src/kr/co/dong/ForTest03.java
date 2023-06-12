package kr.co.dong;

import java.util.Scanner;

public class ForTest03 {
	public static void main(String[] args) {
//		1부터 콘솔로 입력받은 수까지 출력해보기
		int num = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		num = scan.nextInt();
		
		for (int i = 1; i <= num; i++) {
			System.out.print(i + " ");
		}
	}
}
