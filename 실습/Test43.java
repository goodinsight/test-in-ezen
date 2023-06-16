package kr.co.dong;
import java.util.Arrays;
public class Test43 {
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		int[] answer = new int[N];
        float[] rate = new float[N];
        int[] tmp = new int[N];
        for(int i =0; i<N; i++)
            tmp[i] = i+1;
        Arrays.sort(stages);
        
        int idx = 0;
        int cnt = 0;
        int sumofcnt = 0;
        for(int i = 0; i<stages.length; i++){
            if(stages[i] == tmp[idx]){
                cnt++;
            }else{
            	System.out.println("cnt: "+cnt+"len - sum :"+ (stages.length - sumofcnt) );
                sumofcnt += cnt;
                rate[idx] = cnt/(float)(stages.length - sumofcnt);
                cnt = 0;
                i--;
                idx++;
            }
        }
        for(int k =0; k < rate.length; k++){
        	System.out.print(rate[k] + ", ");
        }
        System.out.println();
        for(int k =0; k < tmp.length; k++){
        	System.out.print(tmp[k] + ", ");
        }
        System.out.println();
        System.out.println("=========================");
        for(int i =0; i < tmp.length; i++){
            for(int j=0; j<i; j++){
                if(rate[i] > rate[j]){
                    float tmp1 = rate[i];
                    rate[i] = rate[j];
                    rate[j] = tmp1;
                    int tmp2 = tmp[i];
                    tmp[i] = tmp[j];
                    tmp[j] = tmp2;
                    for(int k =0; k < rate.length; k++){
                    	System.out.print(rate[k] + ", ");
                    }
                    System.out.println();
                    for(int k =0; k < tmp.length; k++){
                    	System.out.print(tmp[k] + ", ");
                    }
                    System.out.println();
                    System.out.println("=========================");
                }    
            }  
        }
        answer = tmp;
        for(int i =0; i < tmp.length; i++){
        	System.out.print(answer[i] + ", ");
        }
	}
}
