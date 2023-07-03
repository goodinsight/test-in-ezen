package kr.co;

public class Test31 {
	public static void main(String[] args) {
		int k = 4;
		int m = 3;
		int[] score = {4,1,2,2,4,4,4,4,1,2,4,2};
		int answer = 0;
	    int[] cnt = new int[k];
	    if(m > score.length){
	        System.out.println(0);
	    }
	    for(int i = 1; i<= score.length; i++){
	        for(int j = 1; j<=k; j++){
	            if(score[i-1] == j){
	                cnt[j-1]++;
	                System.out.println(cnt[j-1]);
	                break;
	            }
	        }
	    }
	    for(int i = cnt.length-1; i>= 0; i--){
	        answer += (i+1) * m * (cnt[i]/m);
	        System.out.println("answer : "+ answer+", "+ (i+1)*m*cnt[i]/m +"= ("+i+"+1) * "+ m + " * cnt["+i+"]/"+m+" : cnt["+i+"] = "+cnt[i]);
	        if(i != 0)
	            cnt[i-1] += cnt[i]%m;
	    }
	    System.out.println(answer);
	}
	
}
