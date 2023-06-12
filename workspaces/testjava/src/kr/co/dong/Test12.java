package kr.co.dong;

public class Test12 {
	public static void main(String[] args) {
		int[] a = {1,5,2,7,123,10,2, 54}; 
		int[] sos = solution(a);
		
		for (int i=0; i<sos.length; i++)
			System.out.println(sos[i]);
	    
	}

	private static int[] solution(int[] arr) {
        int[] stk;
        int[] tmp = new int[arr.length];
        int i = 0;
        int count = 0;
        for (i = 0; i < arr.length; i++){
            if(i != 0){
                if (tmp[count] < arr[i]){
                    tmp[count+1] = arr[i];
                    count++;
                } else if (tmp[count] >= arr[i]){
                    tmp[count] = arr[i];
                }
            } else{
                tmp[i] = arr[i];
            }
        }

        stk = new int[count+1];
        
        for (int j = 0; j <= count; j++ ){
            stk[j] = tmp[j];
        }
        return stk;
    }
}
