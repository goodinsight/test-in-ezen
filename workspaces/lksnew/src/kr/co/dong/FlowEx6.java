package kr.co.dong;

import java.util.Scanner;

public class FlowEx6 {
	public static void main(String[] args) {
//	현재 월을 입력받아서 3,4,5 ->'봄' 6,7,8 -> '여름'
//		9,10,11 ->'가을' 12, 1, 2 ->'겨울'
	
		int month = 0;
		String season = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("현재 월을 입력하세요: ");
		month = scan.nextInt();
		
		switch (month) {
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		default:
			System.out.println("현재 월을 다시 입력하세요.");
			break;
		}
		System.out.println("현재 계절은 " + season + "입니다.");
	}
}
