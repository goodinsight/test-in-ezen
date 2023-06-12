package ch6;

import java.util.ArrayList;

public class ArryListTest02 {
	public static void main(String[] args) {
//		3명의 은행계좌정보를 입력하고 출력하기
		ArrayList<Account> list = new ArrayList<Account>();

		Account ac1 = new Account();
		Account ac2 = new Account();
		Account ac3 = new Account();
		Account ac4 = new Account();

		list.add(ac1);
		list.add(ac2);
		list.add(ac3);

		for (int i = 0; i < list.size(); i++) {
			Account obj = list.get(i);
			System.out.println(obj);
		}
		System.out.println("=====================");

//		예금주와 잔액만 출력하기
		for (int i = 0; i < list.size(); i++) {
			Account obj = list.get(i);
			System.out.println("예금주" + list.get(i).ownerName);
			System.out.println("잔액:" + list.get(i).balance);
		}
//		향상된 for문
		for (Account obj : list) {
			System.out.println("예금주" + obj.ownerName);
			System.out.println("잔액:" + obj.balance);
		}
	}
}
