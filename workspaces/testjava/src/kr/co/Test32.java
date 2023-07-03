package kr.co;
import java.util.*;
public class Test32 {
	public static void main(String[] args) {
		int[] ingredient = {1,1,1,2,3,1,2,3,1,2,1,2,3,1,3,1,1,3,1,2,2,1,1}; 
		int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> idxOf1 = new ArrayList<>();
        for(int i = 0; i<ingredient.length; i++){
            list.add(ingredient[i]);
        }
        for(int i = 0; i< list.size()-3;){
            if(list.get(i) == 1) {
                idxOf1.add(i);
            	System.out.println("1. "+idxOf1.get(idxOf1.size()-1));
            }
            if(list.get(i) == 1 && list.get(i+1) == 2 && list.get(i+2) == 3 && list.get(i+3) == 1){
                answer++;
                
                list.remove(i);
                list.remove(i);
                list.remove(i);
                list.remove(i);
                idxOf1.remove(idxOf1.size()-1);
                System.out.println("2-1. "+ answer);
                if(idxOf1.size() != 0) {
                    i=idxOf1.get(idxOf1.size()-1);
                    idxOf1.remove(idxOf1.size()-1);
                    System.out.println("2. "+idxOf1.get(idxOf1.size()-1));
                }
            }else {
                i++;
            }
        }
        
	        
	    System.out.println("3. "+answer);    
//	    return answer;
	}
}
