package kr.co.dong;

import java.util.Scanner;

public class ForTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		콘솔로 입력받은 수까지 출력해보기
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
//			System.out.println(i);
			System.out.print(i + " ");
		}
	}

}
