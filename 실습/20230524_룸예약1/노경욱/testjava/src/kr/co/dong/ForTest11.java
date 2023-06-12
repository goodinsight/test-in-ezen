package kr.co.dong;

public class ForTest11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		5ÁÙ 9Ä­
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=============");
//		iÁÙ jÄ­
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
