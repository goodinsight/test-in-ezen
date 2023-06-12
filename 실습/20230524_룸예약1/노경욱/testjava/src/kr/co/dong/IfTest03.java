/*
 * 1개의 주사위 숫자를 콘솔로 입력받아서 "던져진 주사위는 0 입니다"를 출력하기
 */
package kr.co.dong;

import java.util.Scanner;

public class IfTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		
		System.out.print("주사위 숫자를 입력하시오: ");
		Scanner input = new Scanner(System.in);
		num = input.nextInt();
		
		if (num == 1) {
			System.out.println("던져진 주사위는 1입니다.");			
		}else if(num == 2) {
			System.out.println("던져진 주사위는 2입니다.");
		}else if(num == 3) {
			System.out.println("던져진 주사위는 3입니다.");
		}else if(num == 4) {
			System.out.println("던져진 주사위는 4입니다.");
		}else if(num == 5) {
			System.out.println("던져진 주사위는 5입니다.");
		}else if(num == 6) {
			System.out.println("던져진 주사위는 6입니다.");
		}else {
			System.out.println("주사위가 이상합니다.");
		}
		
	}

}
