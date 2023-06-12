package ch3;

public class Exercise3_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = 'A';
//		아스키코드
		char lowerCase= ('A' <= ch && ch <= 'Z') ? (char)(ch+32) :ch;
		
		System.out.println("ch:"+ch);
		System.out.println("ch to lowerCase:"+lowerCase);
	}

}
