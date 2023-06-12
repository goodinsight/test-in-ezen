package kr.co.dong;

import java.util.Scanner;

public class IfTeset07 {

	public static void main(String[] args) {
//		점수를 입력받아서 90이상이면 성적이 A, 80이상이면 B
//		70이상이면 C, 60이상이면 D, 60미만이면 F 를 출력하세요
//		
//		추가사항1 : 97이상이면 A+ 93미만이면 A-
//		추가사항2 : 87이상이면 A+ 83미만이면 A-
//		추가사항3 : 77이상이면 A+ 73미만이면 A-
//		추가사항4 : 67이상이면 A+ 63미만이면 A-
//		변경하세요.
				
		Scanner scan = new Scanner(System.in);
		int score = -1;
		char grade = 'x';
		char sign = 'x';

		System.out.print("점수를 입력하세요 : ");
		score = scan.nextInt();
		if (score >= 90) {
			grade = 'A';

		} else if (score >= 80) {
			grade = 'B';

		} else if (score >= 70) {
			grade = 'C';

		} else if (score >= 60) {
			grade = 'D';

		} else {
			grade = 'F';
		}
		if (score >= 60) {
			if(score % 10 >= 7 || score == 100) {
				sign = '+';
			} else if(score % 10 < 3) {
				sign = '-';
			} else {
				sign = ' ';
			}
		} else {
			sign = ' ';
		}
		
		System.out.print("당신의 점수는 "+ score +"점이고, 학점은 "+ grade + sign +"입니다.");
	}
}