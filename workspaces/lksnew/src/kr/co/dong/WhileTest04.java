package kr.co.dong;

public class WhileTest04 {
	public static void main(String[] args) {

		int i = 5;
		while (--i != 0) {

			System.out.println(i + " - I can do it!!!");
		}

		int j = 11;
		while (j-- != 0) {
			System.out.println(j);
		}
		System.out.println("Game Over");
	}
}
