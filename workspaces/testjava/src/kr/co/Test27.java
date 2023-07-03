package kr.co;
import java.util.*;
public class Test27 {
	public static void main(String[] args) {
		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
		HashMap<String, Integer> map = new HashMap<>();
	        for (int i = 0; i<name.length; i++){
	            map.put(name[i], yearning[i]);
	        }
        System.out.println(map.keySet());
        System.out.println(photo[0][0].toString());
	        
        int[] answer = new int[photo.length];
        for(int i = 0; i<photo.length; i++){
            for (int j = 0; j<photo[i].length; j++){
                answer[i] += map.getOrDefault(photo[i][j], 0);
            }
        }
		for (int i = 0; i<answer.length; i++)
			System.out.println(answer[i]+" , ");
	}
}
