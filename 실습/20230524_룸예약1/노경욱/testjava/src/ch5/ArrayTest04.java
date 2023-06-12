package ch5;

public class ArrayTest04 {
	public static void main(String[] args) {
//		최대값과 최소값 구해보기
		int[] score = { 79, 88, 91, 33, 100, 55, 95 };
		int min = 100; //score[0]가능한듯
		int max = 0;

//		최대값 구하고 최소값 구하고 따로 해야 했던듯
//		하나의 대상에 계산한다면 else if		
//		배열에 for문 파트너
		for (int i = 0; i < score.length; i++) {
			if (min > score[i]) {
				min = score[i];
			}else if (max < score[i]) {
				max = score[i];
			}
		}

//		출력
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}
}
