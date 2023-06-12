package kr.co.dong.func;

public class ArrayTest04 {
		int[] score = {};
		int max = 0;
		int min = 0;
		
		ArrayTest04(){
			this.score = new int[]{ 79, 88, 91, 33, 100, 55, 95 };
			this.max = 0;
			this.min = 100;
		}
	
	public static void main(String[] args) {
//		최대값과 최소값을 구해보기


		
		ArrayTest04 tmpArr = new ArrayTest04();
		
		
		tmpArr.max = tmpArr.maxArr(tmpArr.score);
		tmpArr.min = tmpArr.minArr(tmpArr.score);
		System.out.println("최대값 : " + tmpArr.max);
		System.out.println("최소값 : " + tmpArr.min);
	}
	int maxArr(int[] score) {
		int m = 0;
		for (int i = 1; i < score.length; i++) {
			if (score[i] > m) {
				m = score[i];
			}
		}
		return m;
	}
	int minArr(int[] score) {
		int m = 100;
		for (int i = 1; i < score.length; i++) {
			if (score[i] < m) {
				m = score[i];
			}
		}
		return m;
	}
	
	
	
	
}
