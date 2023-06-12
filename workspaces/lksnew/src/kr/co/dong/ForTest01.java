/*
 * 작성자 : 이근섭
 * 일시 : 2023년 5월 8일
 * 값 : Value
 * 참조 : Reference
 * 
 */
package kr.co.dong;

import java.awt.print.Printable;
import java.util.Scanner;

public class ForTest01 {
	public static void main(String[] args) {
/*
//		1부터 10까지의 출력
		for (int i = 1; i <= 10; i++) {
			System.out.println("i=" + i);
		}
//		1부터 n까지의 K의 배수를 출력하기
		int k = 0;
		int n = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("찾고 싶은 수의 범위를 넣으세요:");
		n = scan.nextInt();
		System.out.println("찾고싶은 배수를 넣으세요: ");

		k = scan.nextInt();
		for (int i = 1; i <= n; i++) {
			if (i % k == 0) {
				System.out.println("i=" + i);
			}
		}
*/		
		
		
//		출력 표기 3, 6, 9, 12
//		        15, 18, 21, 24
		int k = 0, l = 0, j = 0, n = 0;
		String comma = ",";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("1분터 몇까지 구할까요?: ");
		n = scan.nextInt();
		System.out.println("배수: ");
		k = scan.nextInt();
		System.out.println("한줄에 표시할 갯수: ");
		l = scan.nextInt();
		System.out.println("무엇으로 구분할까요?: ");
		comma = scan.next();
		
		for (int i = 1; i <= n; i++) {
			if (i % k == 0) {					// i중에서 k배수만 고르기 
				System.out.print(i);			// i값을 출력
				j += 1;							// counting
				if ( j != n / k  ) {			// 갯수가 마지막 숫자와 다를 경우만 실행 -> 마지막에는 콤마를 안찍음
					if (j % l != 0) {			
						System.out.print(comma);// 갯수가 한줄에 표시 갯수(l) 와 다를 경우 콤마
					} else {
						System.out.println();   // 갯수가 l개 되면 줄바꿈
 					}
				}
			}
		}
		
		
		
	}
}
