package kr.co;

public class Test13 {
	public static void main(String[] args) {
		int[] rank = {3, 7, 2, 5, 4, 6, 1};
		boolean[] attendance = {false, true, true, true, true, false, false};
		
		int[] temp = rank.clone();
        boolean[] tmp = attendance;
        for(int i = 0; i<rank.length; i++){
            for(int j = 0; j < i ; j++){
                if(temp[i] < temp[j]){
                    int t = temp[i];
                    temp[i] = temp[j];
                    temp[j] = t;
                    boolean b = tmp[i];
                    tmp[i] = tmp[j];
                    tmp[j] = b;
                }
            }
        }
        for(int i =0; i < tmp.length; i++)
        	System.out.print(tmp[i]+", ");
        for(int i =0; i < tmp.length; i++)
        	System.out.print(temp[i]+", ");
        System.out.println();
        
        int answer = 0;
        int count = 0;
        for(int i =0; i < tmp.length; i++){
            if(tmp[i]){
                for(int j = 0; j< rank.length; j++) {
                	if(rank[j] == temp[i]) {
                		System.out.println("rank[j] : "+rank[j]);
                		System.out.println("temp[i] : "+temp[i]);
                		
                		answer += j;
                		System.out.println("j : " +j);
                	}
                }            	
                count++;
            
            if(count == 3)
                break;
            else
            	System.out.println("answer :"+answer);
                answer *= 100;
                System.out.println(answer);
            }
        }
        System.out.println(answer);
	}
}
