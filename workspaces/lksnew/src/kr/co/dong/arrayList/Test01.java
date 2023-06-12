package kr.co.dong.arrayList;

import java.util.ArrayList;

public class Test01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("배");
		list.add("귤");
		list.add("포도");
		System.out.println(list.get(3));
		list.add(3, "당근");
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		
		
		
	}
}
