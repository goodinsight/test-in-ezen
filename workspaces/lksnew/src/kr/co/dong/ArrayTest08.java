package kr.co.dong;

public class ArrayTest08 {
	public static void main(String[] args) {
//		로또 생성기(1~45)
		int[] lotto = null;	//선언
		lotto = new int[6];	//생성
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45 + 1);
			for (int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;	//i를 리셋하여 다시 받음
				}
			}
		}
	
		System.out.print("로또 번호는 [");
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i]);
			if (i != lotto.length-1) {
				System.out.print(", ");
			}
		}
		System.out.print("] 입니다.");
		
		
		
		
	}
}
