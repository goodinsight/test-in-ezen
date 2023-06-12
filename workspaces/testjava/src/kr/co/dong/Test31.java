package kr.co.dong;
import java.util.*;
public class Test31 {
	public static void main(String[] args) {
		String[] keymap = {"ABACD", "BCEFD"};
		String[] targets = {"ABCD","AABB"};
		HashMap<Character, Integer> map = new HashMap<>();
		// keymap에서 해당 문자(열)이 최소 몇번만에 등장하는지 map으로 mapping
		for(int i = 0; i<keymap.length; i++) {
			for(int j = 0; j<keymap[i].length(); j++) {
				if(!map.containsKey(keymap[i].charAt(j))) {
					map.put(keymap[i].charAt(j), j+1);	// 키를 누르는 횟수는 idx에 1을 더하면 됨.				
				}else {
					if(map.get(keymap[i].charAt(j)) > j) {
						map.replace(keymap[i].charAt(j), j+1);
					}else {
						// 해당 키의 value가 더 클 경우는 수정하지 않음
					}
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i<targets.length; i++) {
        	int sum = 0;
        	for(int j =0; j<targets[i].length(); j++) {
        		char tmp = targets[i].charAt(j);
        		if(tmpCount(map, tmp) != -1) {
        			sum += tmpCount(map, tmp);
        		}else {
        			//return {-1};
        			// return값이 -1일 경우 최종 결과 값을 {-1}로 리턴해야됨
        			System.out.println("{-1}");
        		}
        	}
        	list.add(sum);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i< answer.length; i++) {
        	answer[i] = list.get(i);
        }
        //return answer;
        for(int i = 0; i< answer.length; i++)
        	System.out.print(answer[i]+", ");
	}

	private static int tmpCount(HashMap map, char tmp) {
		// tmp가 keymap에서 몇번을 눌렀을때 찍히는가? -> 가장 적은 횟수를 찾는 메소드를 작성
		// 해당 목표문자열을 작성 없을때는 -1을 리턴
		if(map.containsKey(tmp)) {
			int temp = (int) map.get(tmp);
			return temp;
		}else {
			return -1;
		}
	}
}
