package kr.co.dong;

import java.util.Scanner;

public class SwitchTest04 {
	public static void main(String[] args) {
//		if문으로 처리한 성적처리를 switch문으로 처리해보기
		int score = 0;
		Scanner scan = new Scanner(System.in);
		char grade = 'x';
		char buho = '0';
		System.out.print("점수는: ");
		score = scan.nextInt();

		int res1 = score / 10;
		int res2 = score % 10;
		switch (res1) {
		case 10: case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';
			break;
		}
		switch (res2) {
		case 0: case 1: case 2:
			buho = '-';
			break;
		case 9: case 8: case 7:
			buho = '+';
			break;
		default:
			break;
		}
		if (score == 100) {
			buho = '+';
		}
		System.out.println("당신의 성적은 "+grade+ buho +"입니다.");
	}
}
