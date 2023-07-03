package kr.co;

import java.util.Arrays;

public class Test24 {
	public static void main(String[] args) {
		int[] array = { 3,2,3,4,5,6,2,1,2,3,54,23,1,2,3,4,45,2,125,35,35,125,235,125,3,3,125,125,125,125,124,21,312,312,3,777 };
		Arrays.sort(array);
		int answer = 0;
		int max = 0;
		int maxNum = 0;
		int duplicate = 0;
		int j = 0;
		for (int i = 0; i < 1000; i++) {
			for (j = j; j < array.length; j++) {
				if (array[j] == i) {
					answer++;
					System.out.println("1. ans : " + answer + ", i : " + i + ", j : " + j);
				} else {
					break;
				}
			}
			if (answer > max) {
				max = answer;
				maxNum = i;
				answer = 0;
				duplicate = 0;
				System.out.println(" max : " + max);
			} else if (answer == max && max != 0) {
				duplicate++;
				answer = 0;
				//System.out.println("4.");
			} else {
				answer = 0;
				//System.out.println("5.");
			}
		}
		if (duplicate > 0) {
			System.out.println("6.");
			System.out.println("-1");
//return -1;
		} else{
			System.out.println("7.");
			System.out.println(max);
//       	return max;
		}

	}
}
