package kr.co.dong;

import java.util.Scanner;

public class ForTset09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		시작값과 마지막값을 입력받고 총합을 구하기
		int hap = 0;
		int startt = 1;
		int lastt = 0;

		while (startt > lastt) {
			System.out.print("시작값을 입력하시오: ");
			Scanner scan = new Scanner(System.in);
			startt = scan.nextInt();

			System.out.print("마지막값을 입력하시오: ");
			Scanner scan2 = new Scanner(System.in);
			lastt = scan2.nextInt();
			
			if (startt < lastt) {
				break;
			}
			System.out.println("다시 입력하세요");
		}

		for (int i = startt; i <= lastt; i++) {
			hap = hap + i;
		}
		System.out.println("총합: " + hap);

	}

}
