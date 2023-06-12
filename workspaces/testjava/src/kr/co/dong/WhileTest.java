package kr.co.dong;

public class WhileTest {

	public static void main(String[] args) {
		int i = 0;
		int j = 1000;
		int sum = 0;

		
		while (i<j) {
			++i;
			if (i%3 == 0){
				sum = sum + i;
			}
		}

		System.out.println(sum);
		
	}

}
