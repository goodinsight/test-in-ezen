package kr.co.dong;

import java.util.List;
import java.util.ArrayList;

public class Test16 {
	public static void main(String[] args) {
		int[] arr = {1, 4, 2, 5, 3};
		List<Integer> listA = new ArrayList<Integer>(100000);
		int i = 0;
		int j = 0;
		while(true) {
			if (listA.size() == 0) {
				listA.add(arr[i]);
				System.out.println("1");
				System.out.println(listA);
				i++;
			}else if(listA.get(j) < arr[i]) {
				listA.add(arr[i]);
				System.out.println("2");
				System.out.println(listA);
				j++;
				i++;
			}else if(listA.get(j) >= arr[i]) {
				listA.remove(j);
				System.out.println("3");
				System.out.println(listA);
				if(listA.size() != 0) {
					j--;
				}
			}
			if (i==arr.length) {
				break;
			}
		}
		int[] answer = new int[listA.size()];
	    for (int k = 0 ; k < listA.size() ; k++) 
	        answer[k] = listA.get(k).intValue();
	    System.out.println(listA);
	}
	
}
