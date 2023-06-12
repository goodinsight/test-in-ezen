package kr.co.dong;

import java.util.Scanner;

public class IfTest06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 0;
		String grade = "x";
		Scanner scan1 = new Scanner(System.in);
		System.out.print("점수를 입력하시오: ");
		score = scan1.nextInt();
		
		if(score >= 90) {
			if(score >= 97) {
				grade = "A+";
			}else if(score > 93){
				grade = "A";
			}else{
				grade = "A-";
			}
			
		}else if(score >= 80){
			if(score >= 87) {
				grade = "B+";
			}else if(score > 83) {
				grade = "B";
			}else{
				grade = "B-";
			}
			
		}else if(score >= 70) {
			if(score >= 77) {
				grade = "C+";
			}else if(score > 73){
				grade = "C";
			}else{
				grade = "C-";
			}
			
		}else if(score >= 60) {		
			if (score >= 67) {
				grade = "D+";
			}else if (score > 63) {
				grade = "D";
			}else{
				grade = "D-";
			}
			
		}else{
			grade = "F";
		}
		
		System.out.println("당신의 학점은: " + grade);
	}
}
