package kr.co.dong;

import java.util.ArrayList;

public class Test36 {
	public static void main(String[] args) {
		int k = 4;
		int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
		ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[score.length];
        for(int i = 0; i<score.length; i++){
            if(i < k)
                list.add(score[i]);
            else{
                
                
                
            }
            list.sort(null);
        }
	}
}
