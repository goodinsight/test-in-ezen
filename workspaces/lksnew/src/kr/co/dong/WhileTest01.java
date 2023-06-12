package kr.co.dong;

import java.util.Scanner;

public class WhileTest01 {
	public static void main(String[] args) {
//		정수를 입력받아서 출력하고
//		999 정수는 시스템 종료(반복을 탈출)
		int num = 0;
		Scanner scan = new Scanner(System.in);
		
		boolean stop = false;
		
		while(!stop){
			System.out.print("Input Data (stop => 999):");
			num = scan.nextInt();
			if (num == 999) {
//				break;
				stop = true;
			} 
			System.out.println("입력받은 숫자: " + num);

//			if (num == 999) {
//				break;
//			} else {
//				System.out.println("입력받은 숫자: " + num);
//			}
		}
		
		System.out.println("END!!");
	}
}
