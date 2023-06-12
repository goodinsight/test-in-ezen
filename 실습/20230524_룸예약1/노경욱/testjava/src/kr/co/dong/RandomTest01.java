package kr.co.dong;

public class RandomTest01 {

	public static void main(String[] args) {
//		난수: 0.0 ~ 0.999999999 임의의 수
		System.out.println(Math.random());
		
//		for(초기값; 조건; 증감치){
//			실행문 <- 조건이 참이면 실행
//		}
		System.out.println("----------------------------");
		for(int i=1; i <=6; i++) {	
			System.out.println(i + "일때, " + Math.random());
		}
//		Math.random() -> 0 ~ 0.99999999 임의의 수
//		Math.random() * 10 -> 0 ~ 9.99999999
//		0 ~ 9 임의의 정수 구하기
		System.out.println((int)(Math.random() * 10));
		System.out.println((int)(Math.random() * 10));
		System.out.println((int)(Math.random() * 10));
		System.out.println((int)(Math.random() * 10));
		System.out.println((int)(Math.random() * 10));		
//		0 ~ 7 까지의 임의의 정수
		System.out.println((int)(Math.random() * 8));
		
//		1 ~ 10까지의 임의의 정수
		System.out.println((int)(Math.random() * 10) + 1);
		
//		1 ~ 45까지의 임의의 정수
		System.out.println((int)(Math.random() * 45) + 1);
		
		
//		13 ~ 16까지의 임의의 정수
		System.out.println((int)(Math.random() * 4) + 13);
		
//		3 ~ 15 까지의 임의의 정수
		System.out.println((int)(Math.random() * 13) + 3);
		
	}

}
