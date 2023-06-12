package kr.co.dong;

public class Test10 {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 4, 3};
		int[][] queries = {{0, 4, 2},{0, 3, 2},{0, 2, 2}};
		int[] answer = new int[queries.length];
		
        for (int i = 0; i < queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int c = queries[i][2];
            int[] res = new int[arr.length];
            int max = 0;    
            for (int j = a; j <= b; j++){
                if (arr[j] > c) {
                    res[j] = arr[j];
                }
            }
            for (int j = 0; j < res.length; j++){
                if (max < res[j]) {
                    max = res[j];
                }
            }
            int min = max;
            for (int j = 0; j < res.length; j++){
                if (min >= res[j] && res[j] > c){
                    min = res[j];       
                }
            }    
            if (min == 0)
                answer[i] = -1;
            else
                answer[i] = min;

        }
		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
		
		
		
	}
}
