package kr.co.dong;

import java.util.*;

public class Test48 {
	public static void main(String[] args) {
//		String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
		String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"},{"history", "14:00", "30"}, {"computer", "12:30", "100"}};
//		String[] answer = new String[plans.length];
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();
		HashMap<String, Integer> map3 = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i<plans.length; i++) {
			map1.put(plans[i][0], timeToInt(plans[i][1]));
			map2.put(timeToInt(plans[i][1]), plans[i][0]);
			map3.put(plans[i][0], Integer.parseInt(plans[i][2]));
		}
		int startTime = 23*60+59;
		for(int t : map1.values()) {
			if(startTime > t)
				startTime = t;
		}
		for(int time = startTime; time < 23*60+59 ; time++) {
			if(!stack.isEmpty() && map3.get(stack.lastElement()) != 0) {
				int tmp = map3.get(stack.lastElement());
				map3.put(stack.lastElement(), tmp-1);
			}
			if(!stack.isEmpty() && map3.get(stack.lastElement()) == 0) {
				list.add(stack.pop());
				System.out.println(list.get(list.size()-1)+" 끝난시간:"+time);
				if(list.size() == plans.length)
					break;
			}
			if(map1.containsValue(time)) {
				stack.push(map2.get(time));
			}			
		}
		for(String str : list) {
			System.out.println(str);
		}
	}

	private static int timeToInt(String str) {
		String[] tmp = str.split(":");
		return Integer.parseInt(tmp[0])*60 +Integer.parseInt(tmp[1]); 
	}
}
