package kr.co.dong;

import java.util.Scanner;

public class IfTset05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 0;
		char grade = 'a';
		Scanner scan1 = new Scanner(System.in);
		System.out.print("점수를 입력하시오: ");
		score = scan1.nextInt();
		
		if(score >= 90) {
			grade = 'A';
		}else if(score >= 80	){
			grade = 'B';
		}else if(score >= 70) {
			grade = 'C';
		}else if(score >= 60) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		
		System.out.println(grade);
	}

}
