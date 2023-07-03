package kr.co;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Test11 {
	public static void main(String[] args) {
		String myString = "xxxxdxccxbbbxxxaaaaxxxx";
		myString.replaceAll("x", " ");
		String[] temp = myString.split("x");
		List<String> list = new ArrayList<>();
	    for (int i = 0; i<temp.length; i++) {
	    	if (temp[i] != "")
	    		list.add(temp[i]);
	    }
	    list.sort(Comparator.naturalOrder());
	    String[] answer = new String[list.size()];
	    for (int i = 0; i < answer.length; i++) {
	    	answer[i] = list.get(i);
	    }
	    System.out.println(list.size());
	    for (int i = 0; i < answer.length; i++) {
	    	System.out.print(answer[i]+", ");
	    }
	}
}
