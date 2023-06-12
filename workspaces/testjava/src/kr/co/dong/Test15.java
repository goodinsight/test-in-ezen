package kr.co.dong;

public class Test15 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int[][] intervals = {{1, 3}, {0, 4}};
		int[] answer = new int[intervals[0][1]-intervals[0][0]+intervals[1][1]-intervals[1][0] + 2] ;
		System.out.println(answer.length);
//        for (int i= 0; i <intervals[0][1]-intervals[0][0] + 1 ; i++){
//            answer[i] = arr[intervals[0][0]+i];
//        }
//        for (int i= 0; i <intervals[1][1] -intervals[1][0] + 1 ; i++){
//            answer[intervals[0][1]-intervals[0][0] + 1 + i] = arr[intervals[1][0] +i];
//        }
//        for (int i =0; i < answer.length; i++)
//        	System.out.println(answer[i]);
	}
}
