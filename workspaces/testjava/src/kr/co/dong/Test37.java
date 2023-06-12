package kr.co.dong;
import java.util.*;
public class Test37 {
	public static void main(String[] args) {
		int k = 3;
		int[] score = {10, 100, 20, 150, 1, 100, 200};
		ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[score.length];
        for(int i = 0; i<score.length; i++){
            if(i == 0){
                list.add(score[i]);
            }else{
                for(int j = 0; j < list.size(); j++){
                    if(list.get(j) >= score[i]){ // 오름차순으로 넣음
                        list.add(j, score[i]);
                        break;
                    }else if(j == list.size()-1 && list.get(j) < score[i]) {
                    	list.add(score[i]);
                    	break;
                    }
                }
            }
            System.out.print("i : " + i +"=====>");
            for(int l = 0 ; l<list.size(); l++)
            	System.out.print(list.get(l) + ", ");
            System.out.println();
            if(list.size()<=k)
                answer[i] = list.get(0);
            else{
                answer[i] = list.get(list.size()-k);
            }   
        }
       
        System.out.print("answer : ");
        for(int i = 0; i<answer.length; i++)	
        	System.out.print(answer[i]+ ", ");
	}
}
