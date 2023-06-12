package func;

public class ArrayTest04 {
	public static void main(String[] args) {
//		최대값과 최소값 구해보기
		int[] score = { 79, 88, 91, 33, 100, 55, 95 };
		int min = 100; // 최소값
		int max = 0; // 최대값

//		최대값 구하기: 매개변수 = score배열/ return : 최대값변수
		max = maxArr(score);
//		최소값 구하기:
		min = minArr(score);
//		출력
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}

	static int minArr(int[] score) {
		int n = 101;
		for (int i = 0; i< score.length;i++){
			if (n > score[i]) {
				n = score[i];
			}
		}
		return n;
	}

	static int maxArr(int[] score) {
		int m = 0;
		for (int i = 0; i < score.length; i++) {
			if (m < score[i]) {
				m = score[i];
			}
		}
		return m;
	}
}
