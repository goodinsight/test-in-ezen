/*
 * 1개의 주사위 숫자를 콘솔로 입력받아서 "던져진 주사위는 0 입니다"를 출력하기
 */
package kr.co.dong;

import java.util.Scanner;

public class IfTest03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dice = -1;
		String result = null;
		System.out.print("주사위 숫자를 입력(1~6) : ");
		dice = scan.nextInt();
		if (dice == 1) {
			result = "1";
		} else if (dice == 2) {
			result = "2";
		} else if (dice == 3) {
			result = "3";
		} else if (dice == 4) {
			result = "4";
		} else if (dice == 5) {
			result = "5";
		} else if (dice == 6) {
			result = "6";
		} else {
			System.out.println("누구냐 넌?!?!");
		}
		System.out.println("던져진 주사위는 " + result + "입니다.");		
	}
}
