package kr.co.dong;

import java.util.HashMap;

public class Test39 {
	public static void main(String[] args) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		map.put("R", 0);
		map.put("T", 0);
		map.put("F", 0);
		map.put("C", 0);
		map.put("M", 0);
		map.put("J", 0);
		map.put("A", 0);
		map.put("N", 0);
		for(int i = 0; i < choices.length; i++) {
			if(choices[i] <= 3) {
				map.put(String.valueOf(survey[i].charAt(0)), map.get(String.valueOf(survey[i].charAt(0)))+ 4 - choices[i]);
			System.out.println(map.keySet());
			System.out.println(map.values());
			}else if(choices[i]>=5) {
				map.put(String.valueOf(survey[i].charAt(1)), map.get(String.valueOf(survey[i].charAt(1)))+ choices[i] - 4);
				System.out.println(map.keySet());
				System.out.println(map.values());
			}
		}

		if(map.get("R")>=map.get("T"))
			answer += "R";
		else
			answer += "T";
		if(map.get("C")>=map.get("F"))
			answer += "C";
		else
			answer += "F";
		if(map.get("J")>=map.get("M"))
			answer += "J";
		else
			answer += "M";
		if(map.get("A")>=map.get("N"))
			answer += "A";
		else
			answer += "N";
		System.out.println(answer);
		
	}
}
