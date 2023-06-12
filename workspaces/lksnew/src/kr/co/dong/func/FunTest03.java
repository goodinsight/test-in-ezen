/*
 * 기능 : 정수 배열의 초기화, 배열의 입력, 배열의 정렬, 배열의 출력
 * initArr(배열명), inputArr(배열명), sortArr(배열명), printArr(배열명)
 * 
 */
package kr.co.dong.func;

public class FunTest03 {
	static int[] numArr;
	
	public static void main(String[] args) {
//		10개의 배열을 만들어서 입력 -> 정렬 -> 출력하기
		
		initArr(numArr);
		printArr(numArr);
		
	}
	static void printArr(int[] numArr) {
		for(int i = 0; i < numArr.length; i++) {
			System.out.println(numArr[i]);
		}
	}
	static void initArr(int[] n) {
		n = new int[10];
	}
}
