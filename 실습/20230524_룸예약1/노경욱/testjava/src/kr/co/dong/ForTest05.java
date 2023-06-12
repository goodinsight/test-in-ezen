package kr.co.dong;

import java.util.Scanner;

public class ForTest05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		시작값과 마지막값을 입력받는다
//		그 안의 모든 홀수를 출력한다.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("시작값를 입력하세요: ");
		int firstt = scan.nextInt();
		
		System.out.print("마지막값를 입력하세요: ");
		int lastt = scan.nextInt();

		for (int i = firstt; i <= lastt; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
	}
}
