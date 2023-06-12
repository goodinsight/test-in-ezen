package kr.co.dong;

public class Test11 {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 4, 3};
		int[][] queries = {{0, 4, 1},{0, 3, 2},{0, 3, 3}};
		int[] answer =arr;
			
        for (int i = 0; i < queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int c = queries[i][2];
            
            for (int j = a; j <= b; j++){
                if (j % c == 0) {
                    answer[j] += 1;
                }
            }
            
        }
		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
	}
}
