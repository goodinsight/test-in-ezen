package kr.co.dong;

import java.util.Scanner;

public class SwitchTset04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		if문으로 처리한 성적처리를 switch문으로 처리해보기
//		팁: 봄 여름 가을 겨울 예제를 참고하세요
		int score = 0;
		Scanner scan = new Scanner(System.in);
		char grade = 'x';
		char buho = '0';
		
		System.out.print("점수입력: ");
		score = scan.nextInt();
		
		switch(score / 10) {
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
		
		System.out.println("학점: " + grade);
		
	}

}
