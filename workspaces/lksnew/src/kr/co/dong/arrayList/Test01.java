package kr.co.dong.arrayList;

import java.util.ArrayList;

public class Test01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("���");
		list.add("��");
		list.add("��");
		list.add("����");
		System.out.println(list.get(3));
		list.add(3, "���");
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		
		
		
	}
}
