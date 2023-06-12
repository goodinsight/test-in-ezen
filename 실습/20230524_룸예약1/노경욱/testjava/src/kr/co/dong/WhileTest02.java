package kr.co.dong;

public class WhileTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1부터 10까지의 합 구하기 -> while
		int sum = 0;
		int i = 1;
		
		while(i <= 10) {
			sum = sum + i++;
//			i++;
		}
		System.out.println(sum);
			
//		for (int i = 0; i <= 10; i++) {
//			sum = sum + i;
//		}
//		System.out.println("합: " + sum);
	}

}
