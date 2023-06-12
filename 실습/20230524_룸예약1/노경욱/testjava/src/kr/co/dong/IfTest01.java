/* 두 정수를 콘솔입력 받아서 큰 수를 출력하세요
 * 
 */

package kr.co.dong;

import java.util.Scanner;

public class IfTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		선언문
		int num1 = 0,num2 = 0;
		Scanner scan = new Scanner(System.in);
		
//		입력
		System.out.print("Fisrt Number: ");
		num1 = scan.nextInt();
		System.out.print("Second Number: ");
		num1 = scan.nextInt();
		
//		처리: 큰 수를 찾자
		if(num1 > num2) {
			System.out.println("큰 수는: " + num1);
		}
		else if(num2 > num1) {
			System.out.println("큰 수는: " + num2);
		}
		else {
			System.out.println("두수는 같습니다");
		}
		
		System.out.println("Program END!!");
	}

}
