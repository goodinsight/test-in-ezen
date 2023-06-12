package kr.co.dong.ch06;

import java.util.ArrayList;

public class ArrayListTest02 {
	public static void main(String[] args) {
//		3명의 은행계좌정보를 입력하고 출력하기
		
		ArrayList<Account> list = new ArrayList<Account>();
		
		Account ac1 = new Account("123", "hong1", 20);
		Account ac2 = new Account("223", "hong2", 50);
		Account ac3 = new Account("323", "hong3", 30);
		
		list.add(ac1);
		list.add(ac2);
		list.add(ac3);
		
		for(Account a:list) {
			System.out.println(a);
		}
//		예금주와 잔액만 출력하자
		for (int i = 0; i<list.size(); i++) {
			Account obj = list.get(i);
			System.out.println(obj.ownerName);
			System.out.println(obj.balance);
		}
		
		for(Account a:list) {
			System.out.println(a.ownerName);
			System.out.println(a.balance);
		}
	}
}
