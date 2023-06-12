/*
 * 2개의 주사위를 콘솔로 입력받아서 그 합이 5, 7, 10이면 "당첨", 아니면 "당첨이 아닙니다."
 */
package kr.co.dong;

import java.util.Scanner;

public class IfTset04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 0, num2 = 0, hap = 0;
		
		System.out.print("첫번째 주사위를 입력하시오: ");
		Scanner scan1 = new Scanner(System.in);
		num1 = scan1.nextInt();
		
		System.out.print("두번째 주사위를 입력하시오: ");
		Scanner scan2 = new Scanner(System.in);
		num2 = scan2.nextInt();
		
		hap = num1 + num2;
		
		if (hap == 5 || hap == 7 || hap == 10) {
			System.out.println("당첨입니다.");
		}else {
			System.out.println("당첨이 아닙니다.");
		}
	}

}
