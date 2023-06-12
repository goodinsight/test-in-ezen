/*
 * 2개의 주사위를 입력 받아서 그 합이 5, 7, 10이면  "당첨" 아니면 "당첨이 아닙니다."
 */
package kr.co.dong;

import java.util.Scanner;

public class IfTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int firstDice = -1;
		int secondDice = -1;
		System.out.print("첫번째 주사위 숫자를 입력(1~6) : ");
		firstDice = scan.nextInt();
		System.out.print("두번째 주사위 숫자를 입력(1~6) : ");
		secondDice = scan.nextInt();
		int sum = firstDice + secondDice;
		int[] prize = {5, 7, 10};
		String msg = null;
		boolean found = false;
		for(int x : prize){
			if(x == sum){
		        found = true;
		        break;
		    }
		}
		if (found) {
			msg = "당첨★";
		} else {
			msg = "당첨이 아닙니다.";
		}
		System.out.println("두 주사위의 합은 "+sum+"이고, "+msg+"....");
	}
}
