package kr.co.dong;
import java.util.*;
public class Test31 {
	public static void main(String[] args) {
		String[] keymap = {"ABACD", "BCEFD"};
		String[] targets = {"ABCD","AABB"};
		HashMap<Character, Integer> map = new HashMap<>();
		// keymap���� �ش� ����(��)�� �ּ� ������� �����ϴ��� map���� mapping
		for(int i = 0; i<keymap.length; i++) {
			for(int j = 0; j<keymap[i].length(); j++) {
				if(!map.containsKey(keymap[i].charAt(j))) {
					map.put(keymap[i].charAt(j), j+1);	// Ű�� ������ Ƚ���� idx�� 1�� ���ϸ� ��.				
				}else {
					if(map.get(keymap[i].charAt(j)) > j) {
						map.replace(keymap[i].charAt(j), j+1);
					}else {
						// �ش� Ű�� value�� �� Ŭ ���� �������� ����
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
        			// return���� -1�� ��� ���� ��� ���� {-1}�� �����ؾߵ�
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
		// tmp�� keymap���� ����� �������� �����°�? -> ���� ���� Ƚ���� ã�� �޼ҵ带 �ۼ�
		// �ش� ��ǥ���ڿ��� �ۼ� �������� -1�� ����
		if(map.containsKey(tmp)) {
			int temp = (int) map.get(tmp);
			return temp;
		}else {
			return -1;
		}
	}
}
