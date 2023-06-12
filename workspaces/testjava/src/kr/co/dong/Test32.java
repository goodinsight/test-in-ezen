package kr.co.dong;
import java.util.ArrayList;
import java.util.HashMap;

public class Test32 {
	public static void main(String[] args) {
		String[] cards1 = {"a", "b", "c"};
		String[] cards2 = {"d", "e", "f"};
		
		String[] goal = {"a", "d", "f"};
		
		
		HashMap <String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < goal.length; i++) {
			map.put(goal[i], i);
		}
		
		int[] cards1Arr = new int[cards1.length];
		int[] cards2Arr = new int[cards2.length];
		
		for(int i = 0; i< cards1.length; i++) {
			if(map.containsKey(cards1[i])) {
				cards1Arr[i] = map.get(cards1[i]);
			} else {
				cards1Arr[i] = -1;
			}
		}
		for(int i = 0; i< cards2.length; i++) {
			if(map.containsKey(cards2[i])) {
				cards2Arr[i] = map.get(cards2[i]);
			} else {
				cards2Arr[i] = -1;
			}
		}
		print(cards1Arr);
		print(cards2Arr);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		int a = 100;
		for(int i = 0; i<cards1.length; i++) {
			if(cards1Arr[i] != -1) {
				list1.add(cards1Arr[i]);
			}else {
				list1.add(a);
				a++;
			}
		}
		for(int i = 0; i<cards2.length; i++) {
			if(cards2Arr[i] != -1) {
				list2.add(cards2Arr[i]);
			}else {
				list2.add(a);
				a++;
			}
		}
		boolean list1TOF = true;
		boolean list2TOF = true;
		for(int i = 0; i<list1.size()-1; i++) {
			if(list1.get(i+1) < list1.get(i)) {
				list1TOF = false;
				break;
			}
		}
		for(int i = 0; i<list2.size()-1; i++) {
			if(list2.get(i+1) < list2.get(i)) {
				list2TOF = false;
				break;
			}
		}
		if(list1TOF & list2TOF) {
//			return "Yes";
			System.out.println("Yes");
		}else {
//			return "No";
			System.out.println("No");
			
		}
		
	}
	static void print(int[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print(obj[i]+ ", ");
	}
}
