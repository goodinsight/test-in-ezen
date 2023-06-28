package kr.co.dong;

import java.util.*;

public class Test48 {
	public static void main(String[] args) {
		int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
		int answer = 0;
        int min = 100000000;
        int max = 0;
        for(int i = 0; i<targets.length ; i++){
            if(targets[i][0] <= min)
                min = targets[i][0];
            if(targets[i][1] >= max)
                max = targets[i][1];
        }
        int[][] target = new int[targets.length][2];
        for(int i = 0; i<target.length; i++){
            target[i][0] = targets[i][0];
            target[i][1] = targets[i][1]-1;
        }
        int[] crash = new int[max-min];
        
        for(int i = min; i<max ; i++){
            for(int j = 0; j<target.length; j++){
                if(i>= target[j][0] && i<= target[j][1]){
                    crash[i-min]++;
                }
            }
        }
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = min; i<max ; i++){
            map.put(i, crash[i-min]);
        }
//		System.out.println(map.values());
//		System.out.println(map.keySet());
        
        
		
	}
}
