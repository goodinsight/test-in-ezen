package ch6;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList();
		list.add("����");
		list.add("����");
		list.add("����");

		int num = list.size();

		for (int i = 0; i < num; i++) {
			String str = list.get(i);
			System.out.println(str);

		}
		System.out.println("���� for��");
		for (String str:list) {
			System.out.println(str);
		}
	}

}
