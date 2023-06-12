package ch6;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList();
		list.add("포도");
		list.add("딸기");
		list.add("수박");

		int num = list.size();

		for (int i = 0; i < num; i++) {
			String str = list.get(i);
			System.out.println(str);

		}
		System.out.println("향상된 for문");
		for (String str:list) {
			System.out.println(str);
		}
	}

}
