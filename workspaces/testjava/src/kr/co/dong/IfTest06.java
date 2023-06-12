package kr.co.dong;

import java.util.Scanner;

public class IfTest06 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int score = -1;
		char grade = 'x';
		char sign = 'x';

		while (true) {
			System.out.print("점수를 입력하세요 : ");
			score = scan.nextInt();
			if (score == 100) {
				grade = 'A';
				sign = '+';
			} else if (score >= 60 && score < 100) {
				grade = (char) (74 - score / 10);
				if (score % 10 >= 7) {
					sign = '+';
				} else if (score % 10 < 3) {
					sign = '-';
				} else {
					sign = ' ';
				}
			} else if (score >= 0 && score < 60) {
				grade = 'F';
				sign = ' ';
			} else {
				System.out.println("점수를 잘못 입력하셨습니다.(0~100)");
				continue;
			}
			break;
		}
		System.out.print("당신의 점수는 " + score + "점이고, 학점은 " + grade + sign + "입니다.");
	}
}
